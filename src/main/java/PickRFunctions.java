import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public final class PickRFunctions extends SwingWorker<Integer, String> {

    private ListOfCells cellList1 = new ListOfCells();
    private String workFolder;
    private String outputPath;
    private File openFolder;
    private String workOnFile;
    private ProgressForm form;
    private JFrame frame;

    public PickRFunctions(String workFolder, String outFolder, File openFolder) {
        this.workFolder=workFolder;
        this.outputPath=outFolder;
        this.openFolder=openFolder;
        this.form = new ProgressForm();
        this.frame = new JFrame("PickR by András Laczó");
        frame.setContentPane(this.form.getPanel2());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        frame.setLocationByPlatform(true);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected Integer doInBackground() throws Exception {

        boolean z = SwingUtilities.isEventDispatchThread();
        //show progress



        //start operation
        String path = workFolder;
        final int[] i = {0};

        try {
            Files.walk(openFolder.toPath())
                    .filter((p) -> p.toString().endsWith(".xls") || p.toString().endsWith(".xlsx"))
                    .forEach(item ->
                    {
                        //watch progress
                       publish(item.toString());

                        ExcelReader r1 = new ExcelReader(item.toString());
                        List<ExcelData> inList = r1.getData(cellListToEData.convert(cellList1));

                        if (inList != null) {

                            int colCounter = 0;
                            for (ExcelData eIn : inList) {
                                eIn.setCol(colCounter);
                                colCounter++;
                            }
                            //excelwriter
                            ExcelWriter w1 = new ExcelWriter(outputPath, "sheet1", i[0]);
                            w1.putData(inList, item.toString());
                            i[0]++;
                        }
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
        form.setFileLabel(chunks.get(chunks.size()-1));
        frame.repaint();

    }

    @Override
    protected void done() {
        // Updates
        form.setFileLabel("DONE!");
        frame.repaint();

    }
}
