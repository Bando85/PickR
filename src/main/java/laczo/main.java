package laczo;

import laczo.controller.MainController;
import laczo.model.ListOfCells;
import laczo.model.Model;
import laczo.services.LicenseValidator;
import laczo.view.MainView;
import javax.swing.*;
import java.nio.file.Paths;

/**
 * Created by Andras Laczo. All rights reserved.
 */

class PickRApplication {

    public static void main(String[] args) {

        if (LicenseValidator.isValid()) {

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    MainView view = new MainView();
                    Model model = new Model();

                    MainController controller = new MainController(model, view);

                    view.init();
                    controller.init();
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "Your license is expired!");
        }
    }
}