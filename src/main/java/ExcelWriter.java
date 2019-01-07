import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
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

    //ExcelWriter's constructor
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
            JOptionPane.showMessageDialog(null, "IOException in ExcelWriter");
        }
    }

    public void putData(List<ExcelData> listOut, String openedFile) {

        try {

            XSSFSheet mySheet = myWorkbook.getSheet(sheetname);
            XSSFRow myRow = mySheet.createRow(row);

            for (ExcelData e : listOut) {

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

            myRow.getCell(11, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(openedFile); //show path of actual file

            fos = new FileOutputStream(outputFile);
            myWorkbook.write(fos);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "IOException in ExcelWriter putData");
        } catch (NullPointerException e1) {
            try {
                myWorkbook.write(fos);
                fos.close();
            } catch (IOException e3) {
                e3.printStackTrace();
                JOptionPane.showMessageDialog(null, "IOException in ExcelWriter putData");
            }
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "NullPoint in ExcelWriter");
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(null, "ClassCast in ExcelWriter");
        }

    }
}
/*if (false) { //this never runs
                    if (e.getName().equals("orderDate")) {
                        myRow.getCell(e.getCol(),
                                Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(DateUtil.getJavaDate(((Double) e.getValue()).doubleValue()));

                        // date cellstyle formatting
                        CellStyle cellStyle;
                        cellStyle = myWorkbook.createCellStyle();
                        cellStyle.setDataFormat((short) 14);
                        myRow.getCell(e.getCol()).setCellStyle(cellStyle);
                    }
                }*/
