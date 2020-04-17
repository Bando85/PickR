package laczo;

import laczo.controller.MainController;
import laczo.model.ViewModel;
import laczo.services.LicenseValidator;
import laczo.view.MainView;
import javax.swing.*;

/**
 * Created by Andras Laczo. All rights reserved.
 */

class PickRApplication {

    public static void main(String[] args) {

        if (LicenseValidator.isValid()) {

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    MainView view = new MainView();
                    ViewModel model = new ViewModel();
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