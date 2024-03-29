package laczo.controller;

import laczo.model.ListOfCells;
import laczo.model.RawCellObject;
import laczo.model.Model;
import laczo.services.ExcelColumn;
import laczo.services.PickRFunctions;
import laczo.services.importCells;
import laczo.view.MainView;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * Created by Andras Laczo 2020. 04. 17.
 */

public class MainController {

    private Model model;
    private MainView view;

    public MainController(Model model, MainView view) {
        this.model = model;
        this.view = view;
    }

    public void init() {
        //init source and output path (not used, cause problem with Unix)
        model.setSourceDirectoryPath(new File("").toPath());
        model.setOutputFilePath(new File("").toPath());

        view.getPlayButton().addActionListener(e -> start());
        view.getChooseSourcePathButton().addActionListener(e -> chooseSourceFolder());
        view.getChooseOutputFolderButton().addActionListener(e -> chooseOutputFolder());
        view.getAddCellToListButton().addActionListener(h -> addCellToList());
        view.getImportCellListButton().addActionListener(e -> addImportToJList(importCells.run(model.getCharset())));
        view.getCellList().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                removeCellFromView(e);
            }
        });

        view.getImportCellCharsetComboBox().addActionListener(f -> setImportCellsCharset());
    }

    private void setImportCellsCharset() {
        String comboText = view.getImportCellCharsetComboBox().getSelectedItem().toString();
        if (comboText.equals("UTF_8")) model.setCharset(StandardCharsets.UTF_8);
        if (comboText.equals("ISO_8859_1")) model.setCharset(StandardCharsets.ISO_8859_1);
    }


    public void validateFields() throws ValidationException {
        String idRowText = view.getIdRowTextField().getText();
        try {
            if (!idRowText.equals("")) {
                Integer.parseInt(idRowText);
            }
        } catch (NumberFormatException n) {
            throw new ValidationException("IdRow Field Problem!");
        }
    }

    public void validateModel() throws ValidationException {
        if (model.getSourceDirectoryPath() == null) throw new ValidationException("Source directory problem!");
        if (model.getOutputFilePath() == null) throw new ValidationException("Output directory problem!");
    }

    public void bindViewFieldsToModel() {
        model.setExculdeFileNameLike(view.getExclusionsTextField().getText());
        model.setIdSheetName(view.getIdSheetNameTextField().getText());
        model.setIdCellColumn(view.getIdColTextField().getText());
        String idRowText = view.getIdRowTextField().getText();
        if (idRowText.equals("")) {
            model.setIdCellRow(null);
        } else {
            model.setIdCellRow(Integer.parseInt(idRowText));
        }
        model.setIdValue(view.getIdValueTextField().getText());
    }

    public void start() {
        try {
            validateFields();
            validateModel();
            bindViewFieldsToModel();

            PickRFunctions PF1 = new PickRFunctions(model);
            PF1.execute();

        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.message);
        }
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
            model.getListOfCells().addCell(rowN, colS, sheet);
            model.getCellListViewModel().addElement(colS + rowS + " in sheet " + sheet);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Only numbers for row!");
        }
        view.getCellList().setModel(model.getCellListViewModel());
    }

    private void addImportToJList(ListOfCells listOC) {
        for (RawCellObject cell : listOC) {
            model.getListOfCells().add(cell);
            String col = ExcelColumn.toName(cell.getCol());
            String row = Integer.toString(cell.getRow() + 1);
            String sheet = cell.getSheetName();
            model.getCellListViewModel().addElement(col + row + " in sheet " + sheet);
        }
        view.getCellList().setModel(model.getCellListViewModel());
    }

    private void removeCellFromList(Integer cellPos) {
        model.getListOfCells().remove(cellPos);
        model.getCellListViewModel().removeElementAt(cellPos);
    }

    private void removeCellFromView(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            view.getCellList().setSelectedIndex(view.getCellList().locationToIndex(e.getPoint()));

            JPopupMenu menu = new JPopupMenu();
            JMenuItem itemRemove = new JMenuItem("Remove");
            JMenuItem itemRemoveAll = new JMenuItem("Remove all");
            itemRemove.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (view.getCellList().getSelectedIndex() > -1)
                        removeCellFromList(view.getCellList().getSelectedIndex());
                }
            });
            itemRemoveAll.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    model.getListOfCells().clear();
                    model.getCellListViewModel().clear();
                }
            });
            menu.add(itemRemove);
            menu.add(itemRemoveAll);
            menu.show(view.getCellList(), e.getPoint().x, e.getPoint().y);
        }

    }


    private class ValidationException extends Exception {

        private String message;

        private ValidationException(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }

    }
}
