
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class Csipegeto extends Thread {

    private JTextField textField1;
    private JPanel panel1;
    private JButton playButton;
    private JButton button1;
    private JButton chooseOutputFolderButton;
    private JButton addCellToListButton;
    private JList list1;
    private ListOfCells cellListData = new ListOfCells();
    private JTextField textField2;
    private JTextField textField3;
    private JButton importCellListButton;
    private JTextField textField5;
    private JLabel OutFolderLabel;
    private JTextField idsheetField;
    private JTextField idcellField;
    private JTextField idrowField;
    private JTextField idvalueField;
    private JTextField exclusionsField;
    private File inputFolder;
    private File outputFolder;

    public JTextField getIdsheetField() {
        return idsheetField;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public Csipegeto() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputFolder = new File(textField1.getText());
                outputFolder = new File(OutFolderLabel.getText());

                ExcelOutput ExOut = new ExcelOutput();
                File outFile = ExOut.createFile(outputFolder);
                PickRFunctions PF1 = new PickRFunctions(textField1.getText(), outFile, inputFolder, cellListData,exclusionsField.getText(),
                        idsheetField.getText(), idrowField.getText(),idcellField.getText(),idvalueField.getText());
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

        //Import Cell List from TXT file
        importCellListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addImportToJList(importCells.run());
            }
        });

        inputFolder = new File(textField1.getText());
        outputFolder = new File(OutFolderLabel.getText());

    }

    private void removeCellFromList(Integer cellPos) {
        cellListData.remove(cellPos);
        ((DefaultListModel) list1.getModel()).removeElementAt(cellPos);
    }

    private void addCellToList() {
        String rowS = textField5.getText();
        String colS = textField2.getText();
        String sheet = textField3.getText();

        int rowN;
        try {
            rowN = Integer.parseInt(rowS);
            cellListData.addCell(rowN, colS, sheet);
            ((DefaultListModel) list1.getModel()).addElement(colS + rowS + " in sheet " + sheet);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Only numbers for row!");
        }
    }

    private void addImportToJList(ListOfCells listOC) {
        for (ExcelData cell: listOC) {
            cellListData.add(cell);
            String col = ExcelColumn.toName(cell.getCol());
            String row = Integer.toString(cell.getRow()+1);
            String sheet = cell.getSheetName();
            ((DefaultListModel) list1.getModel()).addElement(col + row + " in sheet " + sheet);
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
                textField1.setText(jfc.getSelectedFile().toString());
                inputFolder = jfc.getSelectedFile();
            }
        }
    }

    public void openFolder2() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory to save your file: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
                outputFolder = jfc.getSelectedFile();
                OutFolderLabel.setText(outputFolder.toString());
            }
        }
    }

    public void run() {
        JFrame frame = new JFrame("PickR by András Laczó");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}