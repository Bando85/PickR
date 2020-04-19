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

                    //for testing
                    model.setOutputFilePath(Paths.get("C:\\test"));
                    model.setSourceDirectoryPath(Paths.get("C:\\test\\augusztus"));

                    MainController controller = new MainController(model, view);

                    //for testing
                    ListOfCells listOfCells = new ListOfCells();
                    listOfCells.addCell(8, "K", "ADATLAP");
                    listOfCells.addCell(25, "G", "ADATLAP");
                    model.setListOfCells(listOfCells);

                    view.init();
                    controller.init();
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "Your license is expired!");
        }
    }
}