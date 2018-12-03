import org.apache.poi.ss.usermodel.CellType;

public class ExcelData {
    private String name;
    private String sheetname;
    private int row;
    private int col;
    private Object value;
    private CellType valueType;

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

    public String getSheetname() {
        return sheetname;
    }

    public void setSheetname(String sheetname) {
        this.sheetname = sheetname;
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
}
