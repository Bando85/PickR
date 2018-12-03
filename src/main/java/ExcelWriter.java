import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelWriter {
    private String path;
    private String sheetname;
    private int row;
    private FileOutputStream fos;
    private XSSFWorkbook myWorkbook;

    //ExcelWriter's constructor
    public ExcelWriter(String p, String s, int r) {
        this.path = p;
        this.sheetname = s;
        this.row = r;

        //if Workbook not exists
        File f = new File(p);
        if (!f.exists()) {
            try {
                InputStream fis = getClass().getResourceAsStream("/template1.xlsx");
                myWorkbook = new XSSFWorkbook(fis);
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { // if exists work at this path
            try {
                FileInputStream fis = new FileInputStream(p);
                myWorkbook = new XSSFWorkbook(fis);
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void putData(List<ExcelData> listOut, String openedFile) {

        try {

            fos = new FileOutputStream(new File(path));

            XSSFSheet mySheet = myWorkbook.getSheet(sheetname);
            XSSFRow myRow = mySheet.createRow(row);

            for (ExcelData e:listOut) {

                if (e.getValue()!=null) {
                    CellType cType = e.getValueType();
                    switch (cType) {
                        case STRING: myRow.getCell(e.getCol(),
                                Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(e.getValue().toString());
                                break;
                        case NUMERIC: myRow.getCell(e.getCol(),
                                Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue((double) (e.getValue()));
                                break;
                        case FORMULA: myRow.getCell(e.getCol(),
                                Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(e.getValue().toString());
                                break;
                    }
                }

                if (false) { //this never runs
                    if (e.getName().equals("orderDate")) {
                        myRow.getCell(e.getCol(),
                                Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(DateUtil.getJavaDate(((Double) e.getValue()).doubleValue()));

                        // date cellstyle formatting
                        CellStyle cellStyle;
                        cellStyle = myWorkbook.createCellStyle();
                        cellStyle.setDataFormat((short) 14);
                        myRow.getCell(e.getCol()).setCellStyle(cellStyle);
                    }
                }
            }

            myRow.getCell(11,  Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(openedFile); //show path of actual file

            myWorkbook.write(fos);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e1) {
            try {
                myWorkbook.write(fos);
                fos.close();
            }
            catch (IOException e3){
                e3.printStackTrace();
            }
            e1.printStackTrace();
        }
        catch (ClassCastException e2) {
            e2.printStackTrace();
        }

    }
}

