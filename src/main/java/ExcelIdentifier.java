import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ExcelIdentifier {
    private String path;
    private String exclusions;
    private String idSheet;
    private int idRow;
    private String idCol;
    private String idValue;


    public ExcelIdentifier(String path, String exclusions, String idSheet, int idRow, String idCol, String idValue) {
        this.path = path;
        this.exclusions = exclusions;
        this.idSheet = idSheet;
        this.idRow = idRow;
        this.idCol = idCol;
        this.idValue = idValue;
    }

    public Boolean run() {
        //first if file name contains the specific user input it returns null
        if (!this.exclusions.equals("")) {
            String[] exArr = this.exclusions.split(",");
            for (String e : exArr) {
                if (path.contains(e)) return false;
            }
        }

        //if user don't want identification then leaves the fields blank
        if (this.idSheet.equals("")) return true;

        //see if contains the sheetList
        if (path.endsWith(".xlsx")) return getDataXSSF();
        if (path.endsWith(".xls")) return getDataHSSF();
        return false;
    }

    private Boolean getDataHSSF() {
        try {
            FileInputStream conn = new FileInputStream(path);
            HSSFWorkbook myWorkbook = new HSSFWorkbook(conn);

            if (myWorkbook.getSheet(this.idSheet) == null) return false;

            HSSFSheet mySheet = myWorkbook.getSheet(this.idSheet);
            HSSFRow myRow = mySheet.getRow(this.idRow-1);
            HSSFCell myCell = myRow.getCell(ExcelColumn.toNumber(this.idCol)-1,
                    Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

            if (myCell.getStringCellValue().equals(idValue)) return true;

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private Boolean getDataXSSF() {
        try {
            FileInputStream conn = new FileInputStream(path);
            XSSFWorkbook myWorkbook = new XSSFWorkbook(conn);

            if (myWorkbook.getSheet(this.idSheet) == null) return false;

            XSSFSheet mySheet = myWorkbook.getSheet(this.idSheet);
            XSSFRow myRow = mySheet.getRow(this.idRow - 1);
            XSSFCell myCell = myRow.getCell(ExcelColumn.toNumber(this.idCol)-1,
                    Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

            if (myCell.getStringCellValue().equals(idValue)) return true;

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
