package laczo.services;

import laczo.model.Model;
import laczo.model.RawCellObject;
import laczo.model.RowFromFile;

import org.apache.poi.ss.usermodel.*;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ExcelReader {
    private Path path;
    private Model model;
    private FileInputStream fis;
    private RowFromFile rowFromFile;

    private List<String> sheetList = Arrays.asList("", ""); // sheetList for identification

    //maybe the problem is with identification

    public ExcelReader(Path path, Model model) {
        this.model = model;
        this.path = path;
        this.rowFromFile = new RowFromFile();
    }

    public RowFromFile getData(List<RawCellObject> listIn) {
        ExcelIdentifier excelIdentifier = new ExcelIdentifier(path.toString(), model.getExculdeFileNameLike(), model.getIdSheetName(),
                model.getIdCellRow(), model.getIdCellColumn(), model.getIdValue()) ;//identify excel files
        if (excelIdentifier.filterByFileName()) {
            try {
                fis = new FileInputStream(path.toFile());
                ExcelIdentifier.setFis(fis);
                Workbook workbook = excelIdentifier.run();
                if (workbook!=null){
                   getDataBoth(workbook, listIn);
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File Not Found in ExcelReader");
            }
        }
        return this.rowFromFile;
    }


    public void getDataBoth(Workbook workbook, List<RawCellObject> listIn) {
        for (RawCellObject e : listIn) {
            Sheet mySheet = workbook.getSheet(e.getSheetName());
            Row myRow = mySheet.getRow(e.getRow());
            Cell myCell = myRow.getCell(e.getCol(),
                    Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            setCellStyleAndValue(myCell);
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

    /*public void getDataXSSF(List<RawCellObject> listIn) {
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
    }*/
}


