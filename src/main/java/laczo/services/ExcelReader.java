package laczo.services;

import laczo.exceptions.MissingWorkbookElementException;
import laczo.model.Model;
import laczo.model.RawCellObject;
import laczo.model.RowFromFile;

import org.apache.poi.hpsf.MissingSectionException;
import org.apache.poi.ss.usermodel.*;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
                model.getIdCellRow(), model.getIdCellColumn(), model.getIdValue());//identify excel files
        if (excelIdentifier.filterByFileName()) {
            try {
                fis = new FileInputStream(path.toFile());
                ExcelIdentifier.setFis(fis);
                Workbook workbook = excelIdentifier.run();
                if (workbook != null) {
                    getDataBoth(workbook, listIn);
                }
                fis.close();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File Not Found in ExcelReader");
            } catch (IOException f) {
                JOptionPane.showMessageDialog(null, "IOException in ExcelReader");
            }
        }
        return this.rowFromFile;
    }

    public void getDataBoth(Workbook workbook, List<RawCellObject> listIn) {
        for (RawCellObject e : listIn) {
            try {
                Sheet mySheet = Optional.ofNullable(workbook.getSheet(e.getSheetName())).
                        orElseThrow(() -> new MissingWorkbookElementException("MissingSheet"));
                Row myRow = Optional.ofNullable(mySheet.getRow(e.getRow())).
                        orElseThrow(() -> new MissingWorkbookElementException("MissingRow"));
                Cell myCell = Optional.ofNullable(myRow.getCell(e.getCol())).
                        orElseThrow(() -> new MissingWorkbookElementException("MissingCell"));
                setCellStyleAndValue(myCell);
            } catch (MissingWorkbookElementException m) {
                RawCellObject cell = new RawCellObject();
                cell.setValueType(CellType.STRING);
                cell.setValue(m.getMessage());
                this.rowFromFile.addCell(cell);
            }
        }
    }

    //generic method to use both XSSF and HSSF cell
    public <C extends Cell> void setCellStyleAndValue(C inputCell) {
        RawCellObject newCell = new RawCellObject();

        if (inputCell.getCellType() == CellType.BLANK) {
            newCell.setValue("BLANK");
            newCell.setValueType(CellType.STRING);
        }
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


