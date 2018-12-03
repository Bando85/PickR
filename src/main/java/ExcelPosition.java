

public class ExcelPosition {
    private String excelColPos;
    private int excelRowPos;

    public ExcelPosition(String excelColPos, int excelRowPos) {
        this.excelColPos = excelColPos;
        this.excelRowPos = excelRowPos;
    }
    public int convertCol() {
            excelColPos = excelColPos.toUpperCase();
            short value = 0;
            for (int i = 0, k = excelColPos.length() - 1; i < excelColPos.length(); i++, k--) {
                int alpabetIndex = ((short) excelColPos.charAt(i)) - 64;
                int delta = 0;
                // last column simply add it
                if (k == 0) {
                    delta = alpabetIndex - 1;
                } else { // aggregate
                    if (alpabetIndex == 0)
                        delta = (26 * k);
                    else
                        delta = (alpabetIndex * 26 * k);
                }
                value += delta;
            }
            return value;

    }

    public int convertRow() {
        return (excelRowPos -1 );
    }
}
