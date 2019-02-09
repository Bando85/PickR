import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public final class PickRFunctions extends SwingWorker<Integer, String> {

    private ListOfCells cellListData;
    private String workFolder;
    private File outputFile;
    private File openFolder;
    private ProgressForm form;
    private JFrame frame;

    private String exclusions;
    private String idSheet;
    private int idRow;
    private String idCol;
    private String idValue;

    public PickRFunctions(String workFolder, File outFile, File openFolder, ListOfCells cellList, String exclusions, String idSheet, int idRow, String idCol, String idValue) {
        this.workFolder=workFolder;
        this.outputFile=outFile;
        this.openFolder=openFolder;
        this.form = new ProgressForm();
        this.frame = new JFrame("PickR by András Laczó");
        this.cellListData = cellList;

        this.exclusions = exclusions;
        this.idSheet = idSheet;
        this.idRow = idRow;
        this.idCol = idCol;
        this.idValue = idValue;

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
            Files.walk(openFolder.toPath())
                    .filter((p) -> p.toString().endsWith(".xls") || p.toString().endsWith(".xlsx"))
                    .forEach(item ->
                    {
                        //watch progress
                       publish(item.toString());

                        ExcelReader r1 = new ExcelReader(item.toString(), exclusions, idSheet, idRow, idCol, idValue) ;
                        ListOfCells lOC = cellListData.makeCopy();
                        List<ExcelData> inList = r1.getData(lOC);

                        if (inList != null) {

                            int colCounter = 0;
                            for (ExcelData eIn : inList) {
                                eIn.setCol(colCounter);
                                colCounter++;
                            }
                            //excelwriter
                            ExcelWriter w1 = new ExcelWriter(outputFile, "sheet1", i[0]);
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
