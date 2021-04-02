package laczo.services;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelIdentifier {
    private String path;
    private String exclusions;
    private String idSheet;
    private Integer idRow;
    private String idCol;
    private String idValue;
    private Workbook workbook;

    private static FileInputStream fis;


    public ExcelIdentifier(String path, String exclusions, String idSheet, Integer idRow, String idCol, String idValue) {
        this.path = path;
        this.exclusions = exclusions;
        this.idSheet = idSheet;
        this.idRow = idRow;
        this.idCol = idCol;
        this.idValue = idValue;
        this.workbook = null;
    }

    public Boolean filterByFileName() {
        //first if file name contains the specific user input it returns null
        if (!this.exclusions.equals("")) {
            String[] exArr = this.exclusions.split(",");
            for (String e : exArr) {
                if (path.contains(e)) return false;
            }
        }
        return true;
    }

    public Workbook run() {

        Workbook workbook;

        try {
            if (path.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
                return (isValid(workbook)) ? workbook : null;
            }
            if (path.endsWith(".xls")) {
                workbook = new HSSFWorkbook(fis);
                return (isValid(workbook)) ? workbook : null;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to open file (Excel Identifier)");
        } catch (Exception f) {
            JOptionPane.showMessageDialog(null, "Unable to load file (Excel Identifier)");
        }
        return null;
    }

    private Boolean isValid(Workbook workbook) {

        //if user don't want identification then leaves the fields blank
        if (this.idSheet.equals("")) return true;

        //if user just sheet identification want then leaves the other fields blank
        if (workbook.getSheet(this.idSheet) == null) return false;
        if (this.idCol.equals("")) return true;

        try {
            Sheet mySheet = workbook.getSheet(this.idSheet);
            Row myRow = mySheet.getRow(this.idRow - 1);
            Cell myCell = myRow.getCell(ExcelColumn.toNumber(this.idCol) - 1,
                    Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (myCell.getStringCellValue().equals(idValue)) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static FileInputStream getFis() {
        return fis;
    }

    public static void setFis(FileInputStream fis) {
        ExcelIdentifier.fis = fis;
    }
}
