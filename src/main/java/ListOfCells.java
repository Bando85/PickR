import java.util.LinkedList;

public class ListOfCells extends LinkedList<ExcelData> {

    public void addCell(int cellRow, String cellCol, String sheetName) {
        this.add(new ExcelData(cellRow - 1, ExcelColumn.toNumber(cellCol) - 1, sheetName));
    }

    public ListOfCells makeCopy() {
        ListOfCells output = new ListOfCells();
        for (ExcelData e:this) {
            output.add(new ExcelData(e.getRow(),e.getCol(),e.getSheetName()));
        }
        return output;
    }
}
