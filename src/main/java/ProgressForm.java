import javax.swing.*;

public class ProgressForm {
    private JPanel panel2;
    private JLabel fileLabel;

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public ProgressForm() {

    }

    public JLabel getFileLabel() {
        return fileLabel;
    }

    public void setFileLabel(String fileLabel) {
        this.fileLabel.setText(fileLabel);
    }
}
