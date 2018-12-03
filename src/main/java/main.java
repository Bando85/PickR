import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Main {
    public static void main(String[] args) {

       // ExcelPosition expos1 = new ExcelPosition("AA",12);// test the excelpos class
        //int a = expos1.convertCol();
        //int b = expos1.convertRow();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = sdf.parse("2018-12-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = new Date();

        if (date1.compareTo(date2) > 0) {
            Csipegeto Csip1 = new Csipegeto();
            Csip1.go();
        }


    }

}