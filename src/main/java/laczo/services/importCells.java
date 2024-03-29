package laczo.services;

import laczo.model.ListOfCells;
import laczo.model.Model;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class importCells {

    private static File openFolder() {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a TXT file: ");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.showOpenDialog(null);
        return jfc.getSelectedFile();
    }

    public static ListOfCells run(Charset charset) {
        File file = openFolder();
        List<String> cellList = null;
        ListOfCells listOC = new ListOfCells();

        if (file != null) {
            try {
                FileInputStream fis = new FileInputStream(file);
                cellList = Files.lines(file.toPath(), charset)
                        .collect(Collectors.toList());

                for (String s : cellList) {
                    String[] arrS = s.split(";");
                    //1st sheet, 2nd col, 3rd row
                    listOC.addCell(Integer.parseInt((arrS[2])), arrS[1], arrS[0]);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "File Not Found in laczo.services.importCells");
            } catch (IOException f) {
                f.printStackTrace();
                JOptionPane.showMessageDialog(null, "IOException in laczo.services.importCells");
            } catch (Exception g) {
                g.printStackTrace();
                JOptionPane.showMessageDialog(null, "Unhandled Exception in laczo.services.importCells");
            }
        }
        return listOC;
    }
}
