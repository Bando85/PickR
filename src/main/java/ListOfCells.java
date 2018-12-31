import java.util.HashMap;

public class ListOfCells {
    public HashMap<Integer, ownCell> getCellList() {
        return cellList;
    }

    private HashMap<Integer, ownCell> cellList = new HashMap<>();
    private Integer counter = 0;

    public Integer getCounter() {
        return counter;
    }

    public Integer addCell (int cellRow, String cellCol, String sheetName) {
        counter++;
        cellList.put(counter, new ownCell(cellRow-1, ExcelColumn.toNumber(cellCol)-1,sheetName));
        return counter;
    }

    public void removeCell (Integer cellID) {
        cellList.remove(cellID);
    }



}
