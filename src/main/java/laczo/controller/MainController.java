package laczo.controller;

import laczo.model.ListOfCells;
import laczo.model.RawCellObject;
import laczo.model.ViewModel;
import laczo.services.ExcelColumn;
import laczo.services.ExcelOutput;
import laczo.services.PickRFunctions;
import laczo.services.importCells;
import laczo.view.MainView;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

/**
 * Created by Andras Laczo 2020. 04. 17.
 */

public class MainController {

    private ViewModel model;
    private MainView view;
    private ListOfCells cellListData = new ListOfCells();

    public MainController(ViewModel model, MainView view) {
        this.model = model;
        this.view = view;
    }

    public void init() {
        //init source and output path
        model.setSourceDirectoryPath(new File("C:\\test\\augusztus").toPath());
        model.setOutputFilePath(new File("C:\\test\\").toPath());

        view.getPlayButton().addActionListener(e -> start());
        view.getChooseSourcePathButton().addActionListener(e -> chooseSourceFolder());
        view.getChooseOutputFolderButton().addActionListener(e -> chooseOutputFolder());
        view.getAddCellToListButton().addActionListener(h -> addCellToList());
        view.getImportCellListButton().addActionListener(e -> addImportToJList(importCells.run()));
        view.getCellList().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                removeCellFromView(e);
            }
        });
        view.getSourcePathTextField().addFocusListener(new SourceTextField());
    }

    public void start() {
        File inputFolder = model.getSourceDirectoryPath().toFile();
        File outputFolder = model.getOutputFilePath().toFile();

        ExcelOutput ExOut = new ExcelOutput();
        File outFile = ExOut.createFile(outputFolder);
        PickRFunctions PF1 = new PickRFunctions(model.getSourceDirectoryPath().toString(), outFile, inputFolder,
                cellListData, view.getExclusionsTextField().getText(), view.getIdSheetNameTextField().getText(),
                view.getIdRowTextField().getText(), view.getIdColTextField().getText(),
                view.getIdValueTextField().getText());
        PF1.execute();
    }

    public void chooseSourceFolder() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
                view.getSourcePathTextField().setText(jfc.getSelectedFile().toString());
                model.setSourceDirectoryPath(jfc.getSelectedFile().toPath());
            }
        }
    }

    public void chooseOutputFolder() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory to save your file: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
                model.setOutputFilePath(jfc.getSelectedFile().toPath());
                view.getOutputFolderLabel().setText(model.getOutputFilePath().toString());
            }
        }
    }

    private void addCellToList() {
        String rowS = view.getAddCellRowTextField().getText();
        String colS = view.getAddCellColTextField().getText();
        String sheet = view.getAddCellSheetTextField().getText();

        int rowN;
        try {
            rowN = Integer.parseInt(rowS);
            cellListData.addCell(rowN, colS, sheet);
            model.getCellListModel().addElement(colS + rowS + " in sheet " + sheet);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Only numbers for row!");
        }
        view.getCellList().setModel(model.getCellListModel());
    }

    private void addImportToJList(ListOfCells listOC) {
        for (RawCellObject cell : listOC) {
            cellListData.add(cell);
            String col = ExcelColumn.toName(cell.getCol());
            String row = Integer.toString(cell.getRow() + 1);
            String sheet = cell.getSheetName();
            model.getCellListModel().addElement(col + row + " in sheet " + sheet);
        }
    }

    private void removeCellFromList(Integer cellPos) {
        cellListData.remove(cellPos);
        model.getCellListModel().removeElementAt(cellPos);
    }

    private void removeCellFromView(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            view.getCellList().setSelectedIndex(view.getCellList().locationToIndex(e.getPoint()));

            JPopupMenu menu = new JPopupMenu();
            JMenuItem itemRemove = new JMenuItem("Remove");
            itemRemove.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (view.getCellList().getSelectedIndex() > -1)
                        removeCellFromList(view.getCellList().getSelectedIndex());
                }
            });
            menu.add(itemRemove);
            menu.show(view.getCellList(), e.getPoint().x, e.getPoint().y);
        }

    }

    private class SourceTextField implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
        }
        @Override
        public void focusLost(FocusEvent e) {
            String pathString = view.getSourcePathTextField().getText();
            File filePath = new File(pathString);
            if (!filePath.isDirectory()) {
                JOptionPane.showMessageDialog(null, "Not a valid path!");
                model.setSourceDirectoryPath(null);
                view.getSourcePathTextField().grabFocus();
            } else {
                model.setSourceDirectoryPath(filePath.toPath());
            }
        }
    }


}
