public class ownCell {
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

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    private int row;
    private int col;
    private String sheetName;

    ownCell(int r, int c, String sname) {
        this.row=r;
        this.col=c;
        this.sheetName = sname;
    }
}
