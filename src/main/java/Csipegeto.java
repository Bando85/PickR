
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Csipegeto extends Thread {

    private JTextField textField1;
    private JPanel panel1;
    private JButton playButton;
    private JTextField textField4;
    private JButton button1;
    private JButton chooseOutputFolderButton;
    private JButton addCellToListButton;
    private JList list1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton importCellListButton;
    private JTextField textField5;
    private File openFolder;
    private File outputFile;
    private ListOfCells cellList1 = new ListOfCells();
    private LinkedList<Integer> jListCells = new LinkedList();
    public static String workOnFile = "";

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public Csipegeto() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PickRFunctions PF1 = new PickRFunctions(textField1.getText(), textField4.getText(), openFolder);
                PF1.execute();
            }
        });
        button1.addActionListener(f -> openFolder());
        chooseOutputFolderButton.addActionListener(g -> openFolder2());
        addCellToListButton.addActionListener(h -> addCellToList());

        //mouse listener for right click in list
        list1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    list1.setSelectedIndex(list1.locationToIndex(e.getPoint()));

                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem itemRemove = new JMenuItem("Remove");
                    itemRemove.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (list1.getSelectedIndex() > -1) removeCellFromList(list1.getSelectedIndex());
                        }
                    });
                    menu.add(itemRemove);
                    menu.show(list1, e.getPoint().x, e.getPoint().y);
                }
            }
        });
        openFolder = new File(textField1.getText());
        outputFile = new File(textField4.getText());
    }

    private void removeCellFromList(Integer cellPos) {
        Integer cellID = jListCells.get(cellPos);
        jListCells.remove(cellPos);
        cellList1.removeCell(cellID);
        ((DefaultListModel) list1.getModel()).removeElementAt(cellPos);
    }

    private void addCellToList() {
        String rowS = textField5.getText();
        int rowN;
        try {
            rowN = Integer.parseInt(rowS);
            jListCells.add(cellList1.addCell(rowN, textField2.getText(), textField3.getText()));
            ((DefaultListModel) list1.getModel()).addElement(textField2.getText() + textField5.getText() + " in sheet "
                    + textField3.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Only numbers for row!");
        }
    }


    public void openFolder() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
            }
        }
        textField1.setText(jfc.getSelectedFile().toString());
        openFolder = jfc.getSelectedFile();
    }

    public void openFolder2() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory to save your file: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
            }
        }
        outputFile = new File(jfc.getSelectedFile(), "output.xlsx");
        textField4.setText(outputFile.toString());
    }

    public void run() {
        JFrame frame = new JFrame("PickR by András Laczó");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        boolean z = SwingUtilities.isEventDispatchThread();

    }
}