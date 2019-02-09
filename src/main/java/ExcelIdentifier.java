import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.List;

public class ExcelIdentifier {
    private String path;
    private List<String> sheetList;


    public ExcelIdentifier(String path, List<String> sheetList) {
        this.path = path;
        this.sheetList = sheetList;
    }

    public Boolean run() {
        //first if file name contains "előzmény", "adatok" it returns null
        if (path.contains("előzmény") || path.contains("adatok")) return false;

        //see if contains the sheetList
        //if (path.endsWith(".xlsx")) return getDataXSSF();
        //if (path.endsWith(".xls")) return getDataHSSF();
        return true;

    }

    private Boolean getDataHSSF() {
        try {
            FileInputStream conn = new FileInputStream(path);
            HSSFWorkbook myWorkbook = new HSSFWorkbook(conn);

            Boolean b1 =false;
            Boolean result=true;

            for (String e : sheetList) { //check sheets in file
               for (int i=0;i<myWorkbook.getNumberOfSheets();i++) {
                   b1 = false;
                   if (e==myWorkbook.getSheetName(i)) {
                       b1 = true;
                       break;
                   }
               }

            result = (result && b1);
            }
            if (result) return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private Boolean getDataXSSF() {
        try {
            FileInputStream conn = new FileInputStream(path);
            XSSFWorkbook myWorkbook = new XSSFWorkbook(conn);

            Boolean b1 =false;
            Boolean result=true;

            for (String e : sheetList) { //check sheets in file
                for (int i=0;i<myWorkbook.getNumberOfSheets();i++) {
                    b1 = false;
                    if (e.equals(myWorkbook.getSheetName(i))) {
                        b1 = true;
                        break;
                    }
                }

                result = (result && b1);
            }
            if (result) return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
