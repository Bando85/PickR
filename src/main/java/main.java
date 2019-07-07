import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Main {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = sdf.parse("2019-08-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = new Date();

        if (date1.compareTo(date2) > 0) {

            Csipegeto Csip1 = new Csipegeto();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame("PickR by András Laczó");
                    frame.setContentPane(Csip1.getPanel1());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "Your license is expired!");
        }
    }
}