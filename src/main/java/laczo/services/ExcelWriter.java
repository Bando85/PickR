package laczo.services;

import laczo.model.RawCellObject;
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

    //laczo.services.ExcelWriter's constructor
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

    public void putData(List<RawCellObject> listOut, String openedFile) {

        try {

            XSSFSheet mySheet = myWorkbook.getSheet(sheetname);
            XSSFRow myRow = mySheet.createRow(row);

            for (RawCellObject e : listOut) {

                if (e.getValue() != null) {
                    CellType cType = e.getValueType();
                    switch (cType) {
                        case STRING:
                            myRow.getCell(e.getCol(),
                                    Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(e.getValue().toString());
                            break;
                        case NUMERIC:
                            myRow.getCell(e.getCol(),
                                    Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue((double) (e.getValue()));
                            break;
                        case FORMULA:
                            myRow.getCell(e.getCol(),
                                    Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(e.getValue().toString());
                            break;
                    }
                }
            }


            myRow.getCell((myRow.getLastCellNum()+2), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(openedFile); //show path of actual file

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
