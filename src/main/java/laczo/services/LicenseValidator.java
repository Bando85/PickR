package laczo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andras Laczo 2020. 04. 17.
 */

public final class LicenseValidator {

    private static final String DEADLINE = "2022-06-01";

    public static boolean isValid() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        try {
            date1 = simpleDateFormat.parse(DEADLINE);
        } catch (ParseException p) {
            System.out.println(p);
        }
        Date date2 = new Date();
        if (date1.compareTo(date2) > 0) {return true;}
        else {return false;}
    }

}
