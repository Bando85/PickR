package laczo.model;

import laczo.services.ExcelColumn;

import java.util.LinkedList;

public class ListOfCells extends LinkedList<RawCellObject> {

    public void addCell(int cellRow, String cellCol, String sheetName) {
        this.add(new RawCellObject(cellRow - 1, ExcelColumn.toNumber(cellCol) - 1, sheetName));
    }

    public ListOfCells makeCopy() {
        ListOfCells output = new ListOfCells();
        for (RawCellObject e:this) {
            output.add(new RawCellObject(e.getRow(),e.getCol(),e.getSheetName()));
        }
        return output;
    }
}
