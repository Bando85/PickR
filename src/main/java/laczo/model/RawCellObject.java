package laczo.model;

import org.apache.poi.ss.usermodel.CellType;

public class RawCellObject {
    private String name;
    private String sheetName;
    private String workbookName;
    private int row;
    private int col;
    private Object value;
    private CellType valueType;

    public RawCellObject() {
    }

    public RawCellObject(int r, int c, String sname) {
        this.row = r;
        this.col = c;
        this.sheetName = sname;
    }

    public CellType getValueType() {
        return valueType;
    }

    public void setValueType(CellType valueType) {
        this.valueType = valueType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getWorkbookName() {
        return workbookName;
    }

    public void setWorkbookName(String workbookName) {
        this.workbookName = workbookName;
    }
}
