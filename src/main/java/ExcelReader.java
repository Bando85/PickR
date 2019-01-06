import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
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
    private List<String> sheetList = Arrays.asList("ADATLAP", "FEDLAP"); // sheetList for identification

    public ExcelReader(String p) {
        this.path=p;
    }

    public List<ExcelData> getData(List<ExcelData> listIn) {
        ExcelIdentifier exid = new ExcelIdentifier(path, sheetList);//identify excel files
        if (exid.run()) {
            try {
                fis = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "File Not Found in ExcelReader");
            }
            if (path.endsWith(".xlsx")) return getDataXSSF(listIn);
            if (path.endsWith(".xls")) return getDataHSSF(listIn);
        }
        return null;
    }

    public List<ExcelData> getDataXSSF(List<ExcelData> listIn) {
        try {
            XSSFWorkbook myWorkbook = new XSSFWorkbook(fis);
            for (ExcelData e : listIn) {
                XSSFSheet mySheet = myWorkbook.getSheet(e.getSheetName());
                XSSFRow myRow = mySheet.getRow(e.getRow());
                XSSFCell myCell = myRow.getCell(e.getCol(),
                        Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                setCellStyleAndValue(e, myCell);
            }
            fis.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "IOException in getDataXSSF");
        }
        return listIn;
    }



    public List<ExcelData> getDataHSSF(List<ExcelData> listIn) {
        try {
            HSSFWorkbook myWorkbook = new HSSFWorkbook(fis);
            for (ExcelData e : listIn) {
                HSSFSheet mySheet = myWorkbook.getSheet(e.getSheetName());
                HSSFRow myRow = mySheet.getRow(e.getRow());
                HSSFCell myCell = myRow.getCell(e.getCol(),
                        Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                setCellStyleAndValue(e, myCell);

            }
            fis.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "IOException in getDataHSSF");
        }
             return listIn;
    }

    //generic method to use both XSSF and HSSF cell
    public <C extends Cell> void setCellStyleAndValue(ExcelData eDataOutput, C inputCell) {
        if (inputCell.getCellType() == CellType.STRING) {
            eDataOutput.setValue(inputCell.getRichStringCellValue());
            eDataOutput.setValueType(CellType.STRING);
        }

        if (inputCell.getCellType() == CellType.NUMERIC) {
            eDataOutput.setValue(inputCell.getNumericCellValue());
            eDataOutput.setValueType(CellType.NUMERIC);
        }
        if (inputCell.getCellType() == CellType.BOOLEAN) {
            eDataOutput.setValue(inputCell.getBooleanCellValue());
            eDataOutput.setValueType(CellType.BOOLEAN);
        }
        if (inputCell.getCellType() == CellType.ERROR) {
            eDataOutput.setValue(inputCell.getErrorCellValue());
            eDataOutput.setValueType(CellType.ERROR);
        }
        if (inputCell.getCellType() == CellType.FORMULA) {
            eDataOutput.setValue(inputCell.getCellFormula());
            eDataOutput.setValueType(CellType.FORMULA);
        }
    }
}


