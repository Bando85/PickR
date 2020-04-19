package laczo.services;

import laczo.model.Model;
import laczo.model.RowFromFile;
import laczo.view.ProgressView;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public final class PickRFunctions extends SwingWorker<Integer, String> {

    private Model model;
    private ProgressView form;
    private JFrame frame;

    public PickRFunctions(Model model) {
        this.model = model;
        this.form = new ProgressView();
        this.frame = new JFrame("PickR by András Laczó");

        frame.setContentPane(this.form.getPanel2());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected Integer doInBackground() {

        final int[] i = {0};

        try {
            Files.walk(model.getSourceDirectoryPath())
                    .filter((p) -> p.toString().endsWith(".xls") || p.toString().endsWith(".xlsx"))
                    .forEach(item ->
                    {
                        //watch progress
                        publish(item.toString());

                        ExcelReader r1 = new ExcelReader(item.toString(), model.getExculdeFileNameLike(), model.getIdSheetName(),
                                model.getIdCellRow(), model.getIdCellColumn(), model.getIdValue());
                        RowFromFile newRow = r1.getData(model.getListOfCells());
                        newRow.setFileName(item);

                        //excelwriter
                        ExcelWriter w1 = new ExcelWriter(model.getOutputFilePath().toFile(), "sheet1", i[0]);
                        w1.putData(newRow);
                        i[0]++;
                    });

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "IOException in FilesWalk");
        }
        return 100;
    }


    @Override
    protected void process(final List<String> chunks) {
        // Updates
        form.setFileLabel(chunks.get(chunks.size() - 1));
        frame.repaint();

    }

    @Override
    protected void done() {
        // Updates
        form.setFileLabel("DONE!");
        frame.repaint();

    }
}
