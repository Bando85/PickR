package laczo;

import laczo.controller.MainController;
import laczo.model.Model;
import laczo.services.LicenseValidator;
import laczo.view.MainView;

import javax.swing.*;

import java.nio.file.Paths;

class PickRApplicationTest {

    private Model model;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        model = new Model();
        model.setOutputFilePath(Paths.get("C:\\test"));
        model.setSourceDirectoryPath(Paths.get("C:\\test\\augusztus"));

    }

    @org.junit.jupiter.api.Test
    void main() {
        if (LicenseValidator.isValid()) {
            MainView view = new MainView();
            MainController controller = new MainController(model, view);
            view.init();
            controller.init();

        } else {
            JOptionPane.showMessageDialog(null, "Your license is expired!");
        }

    }
}