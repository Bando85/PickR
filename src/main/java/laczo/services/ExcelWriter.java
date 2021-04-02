package laczo.services;

import laczo.model.RawCellObject;
import laczo.model.RowFromFile;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class ExcelWriter {
    private String sheetname;
    private int row;
    private File outputFile;
    private FileOutputStream fos;
    private XSSFWorkbook myWorkbook;

    public ExcelWriter(File f, String s, int r) {
        this.outputFile = f;
        this.sheetname = s;
        this.row = r;

        try {
            FileInputStream fis = new FileInputStream(f);
            myWorkbook = new XSSFWorkbook(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "IOException in laczo.services.ExcelWriter");
        }
    }

    public void putData(RowFromFile newRow) {

        Integer starterColPos = 2;

        try {
            XSSFSheet mySheet = myWorkbook.getSheet(sheetname);
            XSSFRow myRow = mySheet.createRow(row);

            myRow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(newRow.getFileName().toString()); //show path of actual file

            for (RawCellObject e : newRow.getCells()) {
                if (e.getValue() != null) {
                    CellType cType = e.getValueType();
                    switch (cType) {
                        case STRING:
                        case FORMULA:
                            myRow.getCell(starterColPos + newRow.getCells().indexOf(e),
                                    Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(e.getValue().toString());
                            break;
                        case NUMERIC:
                            myRow.getCell(starterColPos + newRow.getCells().indexOf(e),
                                    Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue((double) (e.getValue()));
                            break;
                    }
                }
            }



            fos = new FileOutputStream(outputFile);
            myWorkbook.write(fos);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "IOException in laczo.services.ExcelWriter putData");
        } catch (NullPointerException e1) {
            try {
                myWorkbook.write(fos);
                fos.close();
            } catch (IOException e3) {
                e3.printStackTrace();
                JOptionPane.showMessageDialog(null, "IOException in laczo.services.ExcelWriter putData");
            }
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "NullPoint in laczo.services.ExcelWriter");
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(null, "ClassCast in laczo.services.ExcelWriter");
        }

    }
}
