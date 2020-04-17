package laczo.services;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ExcelOutput {

    public File createFile(File outputFolder) {
        // check if output exists
        String fileName = "/output";
        String fileExt = ".xlsx";
        String pathString = outputFolder.toString() + fileName + fileExt;
        Path path = Paths.get(pathString);

        //create file that not exists
        for (int i=1; Files.exists(path); i++) {
            pathString = outputFolder.toString() + fileName + i + fileExt;
            path = Paths.get(pathString);
        }

        try {
            InputStream fis = getClass().getResourceAsStream("/template1.xlsx");
            XSSFWorkbook myWorkbook = new XSSFWorkbook(fis);
            File outFile = new File (path.toString());
            FileOutputStream fos = new FileOutputStream(outFile);
            myWorkbook.write(fos);
            fis.close();
            fos.close();

            return outFile;
        } catch (
                IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "IOException in laczo.services.ExcelOutput");
            return null;
        }
    }
}
