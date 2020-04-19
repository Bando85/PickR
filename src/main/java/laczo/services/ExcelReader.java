package laczo.services;

import laczo.model.RawCellObject;
import laczo.model.RowFromFile;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExcelReader {
    private String path;
    private FileInputStream fis;
    private String exclusions;
    private String idSheet;
    private int idRow;
    private String idCol;
    private String idValue;
    private RowFromFile rowFromFile;

    private List<String> sheetList = Arrays.asList("", ""); // sheetList for identification

    //maybe the problem is with identification

    public ExcelReader(String p, String exclusions, String idSheet, int idRow, String idCol, String idValue) {
        this.path = p;
        this.exclusions = exclusions;
        this.idSheet = idSheet;
        this.idRow = idRow;
        this.idCol = idCol;
        this.idValue = idValue;
        this.sheetList = sheetList;
        this.rowFromFile = new RowFromFile();
    }

    public RowFromFile getData(List<RawCellObject> listIn) {
        ExcelIdentifier exid = new ExcelIdentifier(path, exclusions, idSheet, idRow, idCol, idValue);//identify excel files
        if (exid.run()) {
            try {
                fis = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "File Not Found in laczo.services.ExcelReader");
            }
            if (path.endsWith(".xlsx")) {getDataXSSF(listIn);}
            if (path.endsWith(".xls")) {getDataHSSF(listIn);}
        }
        return this.rowFromFile;
    }


    public void getDataXSSF(List<RawCellObject> listIn) {
        try {
            XSSFWorkbook myWorkbook = new XSSFWorkbook(fis);
            for (RawCellObject e : listIn) {
                XSSFSheet mySheet = myWorkbook.getSheet(e.getSheetName());
                XSSFRow myRow = mySheet.getRow(e.getRow());
                XSSFCell myCell = myRow.getCell(e.getCol(),
                        Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                setCellStyleAndValue(myCell);
            }
            fis.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "IOException in getDataXSSF");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getDataHSSF(List<RawCellObject> listIn) {
        try {
            HSSFWorkbook myWorkbook = new HSSFWorkbook(fis);
            for (RawCellObject e : listIn) {
                HSSFSheet mySheet = myWorkbook.getSheet(e.getSheetName());
                HSSFRow myRow = mySheet.getRow(e.getRow());
                HSSFCell myCell = myRow.getCell(e.getCol(),
                        Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                setCellStyleAndValue(myCell);
            }
            fis.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "IOException in getDataHSSF");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //generic method to use both XSSF and HSSF cell
    public <C extends Cell> void setCellStyleAndValue(C inputCell) {
        RawCellObject newCell = new RawCellObject();

        if (inputCell.getCellType() == CellType.STRING) {
            newCell.setValue(inputCell.getRichStringCellValue());
            newCell.setValueType(CellType.STRING);
        }
        if (inputCell.getCellType() == CellType.NUMERIC) {
            newCell.setValue(inputCell.getNumericCellValue());
            newCell.setValueType(CellType.NUMERIC);
        }
        if (inputCell.getCellType() == CellType.BOOLEAN) {
            newCell.setValue(inputCell.getBooleanCellValue());
            newCell.setValueType(CellType.BOOLEAN);
        }
        if (inputCell.getCellType() == CellType.ERROR) {
            newCell.setValue(inputCell.getErrorCellValue());
            newCell.setValueType(CellType.ERROR);
        }
        if (inputCell.getCellType() == CellType.FORMULA) {

            if (inputCell.getCachedFormulaResultType() == CellType.NUMERIC) {
                newCell.setValue(inputCell.getNumericCellValue());
                newCell.setValueType(CellType.NUMERIC);
            }
            if (inputCell.getCachedFormulaResultType() == CellType.STRING) {
                newCell.setValue(inputCell.getStringCellValue());
                newCell.setValueType(CellType.STRING);
            }
            if (inputCell.getCellType() == CellType.BOOLEAN) {
                newCell.setValue(inputCell.getBooleanCellValue());
                newCell.setValueType(CellType.BOOLEAN);
            }
            if (inputCell.getCellType() == CellType.ERROR) {
                newCell.setValue(inputCell.getErrorCellValue());
                newCell.setValueType(CellType.ERROR);
            }
        }

        this.rowFromFile.addCell(newCell);

    }
}


