package laczo.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import laczo.model.ListOfCells;
import javax.swing.*;
import java.awt.*;


public class MainView {

    private JFrame mainFrame;
    private JTextField sourcePathTextField;
    private JPanel mainPanel;
    private JButton playButton;
    private JButton chooseSourcePathButton;
    private JButton chooseOutputFolderButton;
    private JButton addCellToListButton;
    private JList cellList;
    private ListOfCells cellListData = new ListOfCells();
    private JTextField addCellColTextField;
    private JTextField addCellSheetTextField;
    private JButton importCellListButton;
    private JTextField addCellRowTextField;
    private JLabel outputFolderLabel;
    private JTextField idSheetNameTextField;
    private JTextField idColTextField;
    private JTextField idRowTextField;
    private JTextField idValueTextField;
    private JTextField exclusionsTextField;
    private JLabel sourcePathLabel;
    private JPanel innerPanel;
    private JLabel outputPathLabel;
    private JLabel howTheListWorksLabel;
    private JScrollPane scrollPane;
    private JLabel idMainLabel;
    private JLabel idSheetLabel;
    private JLabel idColLabel;
    private JLabel idValueLabel;
    private JLabel idRowLabel;
    private JLabel excludeFileLabel;
    private JLabel addCellColLabel;
    private JLabel addCellRowLabel;
    private JLabel addCellSheetLabel;

    public void init() {

        mainFrame = new JFrame("PickR by András Laczó");
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void refresh() {
        mainFrame.pack();
    }

    public JTextField getSourcePathTextField() {
        return sourcePathTextField;
    }

    public void setSourcePathTextField(JTextField sourcePathTextField) {
        this.sourcePathTextField = sourcePathTextField;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public void setPlayButton(JButton playButton) {
        this.playButton = playButton;
    }

    public JButton getChooseSourcePathButton() {
        return chooseSourcePathButton;
    }

    public void setChooseSourcePathButton(JButton chooseSourcePathButton) {
        this.chooseSourcePathButton = chooseSourcePathButton;
    }

    public JButton getChooseOutputFolderButton() {
        return chooseOutputFolderButton;
    }

    public void setChooseOutputFolderButton(JButton chooseOutputFolderButton) {
        this.chooseOutputFolderButton = chooseOutputFolderButton;
    }

    public JButton getAddCellToListButton() {
        return addCellToListButton;
    }

    public void setAddCellToListButton(JButton addCellToListButton) {
        this.addCellToListButton = addCellToListButton;
    }

    public JList getCellList() {
        return cellList;
    }

    public void setCellList(JList cellList) {
        this.cellList = cellList;
    }

    public ListOfCells getCellListData() {
        return cellListData;
    }

    public void setCellListData(ListOfCells cellListData) {
        this.cellListData = cellListData;
    }

    public JTextField getAddCellColTextField() {
        return addCellColTextField;
    }

    public void setAddCellColTextField(JTextField addCellColTextField) {
        this.addCellColTextField = addCellColTextField;
    }

    public JTextField getAddCellSheetTextField() {
        return addCellSheetTextField;
    }

    public void setAddCellSheetTextField(JTextField addCellSheetTextField) {
        this.addCellSheetTextField = addCellSheetTextField;
    }

    public JButton getImportCellListButton() {
        return importCellListButton;
    }

    public void setImportCellListButton(JButton importCellListButton) {
        this.importCellListButton = importCellListButton;
    }

    public JTextField getAddCellRowTextField() {
        return addCellRowTextField;
    }

    public void setAddCellRowTextField(JTextField addCellRowTextField) {
        this.addCellRowTextField = addCellRowTextField;
    }

    public JLabel getOutputFolderLabel() {
        return outputFolderLabel;
    }

    public void setOutputFolderLabel(JLabel outputFolderLabel) {
        this.outputFolderLabel = outputFolderLabel;
    }

    public JTextField getIdSheetNameTextField() {
        return idSheetNameTextField;
    }

    public void setIdSheetNameTextField(JTextField idSheetNameTextField) {
        this.idSheetNameTextField = idSheetNameTextField;
    }

    public JTextField getIdColTextField() {
        return idColTextField;
    }

    public void setIdColTextField(JTextField idColTextField) {
        this.idColTextField = idColTextField;
    }

    public JTextField getIdRowTextField() {
        return idRowTextField;
    }

    public void setIdRowTextField(JTextField idRowTextField) {
        this.idRowTextField = idRowTextField;
    }

    public JTextField getIdValueTextField() {
        return idValueTextField;
    }

    public void setIdValueTextField(JTextField idValueTextField) {
        this.idValueTextField = idValueTextField;
    }

    public JTextField getExclusionsTextField() {
        return exclusionsTextField;
    }

    public void setExclusionsTextField(JTextField exclusionsTextField) {
        this.exclusionsTextField = exclusionsTextField;
    }

    public JLabel getSourcePathLabel() {
        return sourcePathLabel;
    }

    public void setSourcePathLabel(JLabel sourcePathLabel) {
        this.sourcePathLabel = sourcePathLabel;
    }

    public JPanel getInnerPanel() {
        return innerPanel;
    }

    public void setInnerPanel(JPanel innerPanel) {
        this.innerPanel = innerPanel;
    }

    public JLabel getOutputPathLabel() {
        return outputPathLabel;
    }

    public void setOutputPathLabel(JLabel outputPathLabel) {
        this.outputPathLabel = outputPathLabel;
    }

    public JLabel getHowTheListWorksLabel() {
        return howTheListWorksLabel;
    }

    public void setHowTheListWorksLabel(JLabel howTheListWorksLabel) {
        this.howTheListWorksLabel = howTheListWorksLabel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JLabel getIdMainLabel() {
        return idMainLabel;
    }

    public void setIdMainLabel(JLabel idMainLabel) {
        this.idMainLabel = idMainLabel;
    }

    public JLabel getIdSheetLabel() {
        return idSheetLabel;
    }

    public void setIdSheetLabel(JLabel idSheetLabel) {
        this.idSheetLabel = idSheetLabel;
    }

    public JLabel getIdColLabel() {
        return idColLabel;
    }

    public void setIdColLabel(JLabel idColLabel) {
        this.idColLabel = idColLabel;
    }

    public JLabel getIdValueLabel() {
        return idValueLabel;
    }

    public void setIdValueLabel(JLabel idValueLabel) {
        this.idValueLabel = idValueLabel;
    }

    public JLabel getIdRowLabel() {
        return idRowLabel;
    }

    public void setIdRowLabel(JLabel idRowLabel) {
        this.idRowLabel = idRowLabel;
    }

    public JLabel getExcludeFileLabel() {
        return excludeFileLabel;
    }

    public void setExcludeFileLabel(JLabel excludeFileLabel) {
        this.excludeFileLabel = excludeFileLabel;
    }

    public JLabel getAddCellColLabel() {
        return addCellColLabel;
    }

    public void setAddCellColLabel(JLabel addCellColLabel) {
        this.addCellColLabel = addCellColLabel;
    }

    public JLabel getAddCellRowLabel() {
        return addCellRowLabel;
    }

    public void setAddCellRowLabel(JLabel addCellRowLabel) {
        this.addCellRowLabel = addCellRowLabel;
    }

    public JLabel getAddCellSheetLabel() {
        return addCellSheetLabel;
    }

    public void setAddCellSheetLabel(JLabel addCellSheetLabel) {
        this.addCellSheetLabel = addCellSheetLabel;
    }



    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(14, 8, new Insets(30, 30, 30, 30), -1, -1));
        sourcePathTextField = new JTextField();
        sourcePathTextField.setText("C:\\test\\augusztus");
        mainPanel.add(sourcePathTextField, new GridConstraints(1, 0, 1, 8, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        sourcePathLabel = new JLabel();
        sourcePathLabel.setText("Source Directory Path");
        mainPanel.add(sourcePathLabel, new GridConstraints(0, 0, 1, 8, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(222, 16), null, 0, false));
        innerPanel = new JPanel();
        innerPanel.setLayout(new GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(innerPanel, new GridConstraints(9, 0, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        addCellToListButton = new JButton();
        addCellToListButton.setText("Add cell to list");
        innerPanel.add(addCellToListButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addCellColLabel = new JLabel();
        addCellColLabel.setText("Cell Column");
        innerPanel.add(addCellColLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(95, 16), null, 0, false));
        addCellColTextField = new JTextField();
        addCellColTextField.setText("");
        innerPanel.add(addCellColTextField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addCellRowLabel = new JLabel();
        addCellRowLabel.setText("Cell Row");
        innerPanel.add(addCellRowLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addCellSheetLabel = new JLabel();
        addCellSheetLabel.setText("Sheet name");
        innerPanel.add(addCellSheetLabel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addCellSheetTextField = new JTextField();
        innerPanel.add(addCellSheetTextField, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addCellRowTextField = new JTextField();
        addCellRowTextField.setText("");
        innerPanel.add(addCellRowTextField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        outputPathLabel = new JLabel();
        outputPathLabel.setText("Output Path");
        mainPanel.add(outputPathLabel, new GridConstraints(3, 0, 1, 8, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(65, 32), null, 0, false));
        chooseSourcePathButton = new JButton();
        chooseSourcePathButton.setText("Choose folder");
        mainPanel.add(chooseSourcePathButton, new GridConstraints(2, 0, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chooseOutputFolderButton = new JButton();
        chooseOutputFolderButton.setText("Choose output folder");
        mainPanel.add(chooseOutputFolderButton, new GridConstraints(5, 0, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(222, 30), null, 0, false));
        howTheListWorksLabel = new JLabel();
        howTheListWorksLabel.setText("Added cells (right click to remove from list)");
        mainPanel.add(howTheListWorksLabel, new GridConstraints(11, 0, 1, 8, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importCellListButton = new JButton();
        importCellListButton.setText("Import cell list");
        mainPanel.add(importCellListButton, new GridConstraints(10, 0, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scrollPane = new JScrollPane();
        mainPanel.add(scrollPane, new GridConstraints(12, 0, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        cellList = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        cellList.setModel(defaultListModel1);
        scrollPane.setViewportView(cellList);
        outputFolderLabel = new JLabel();
        outputFolderLabel.setText("C:\\test");
        mainPanel.add(outputFolderLabel, new GridConstraints(4, 0, 1, 8, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        idMainLabel = new JLabel();
        idMainLabel.setText("Identification");
        mainPanel.add(idMainLabel, new GridConstraints(6, 0, 1, 8, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        idSheetLabel = new JLabel();
        idSheetLabel.setText("ID Sheet");
        mainPanel.add(idSheetLabel, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        idSheetNameTextField = new JTextField();
        mainPanel.add(idSheetNameTextField, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        idColLabel = new JLabel();
        idColLabel.setText("ID Cell Column");
        mainPanel.add(idColLabel, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        idColTextField = new JTextField();
        mainPanel.add(idColTextField, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        idValueLabel = new JLabel();
        idValueLabel.setText("ID Value");
        mainPanel.add(idValueLabel, new GridConstraints(7, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        idRowLabel = new JLabel();
        idRowLabel.setText("ID Cell Row");
        mainPanel.add(idRowLabel, new GridConstraints(7, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        idRowTextField = new JTextField();
        mainPanel.add(idRowTextField, new GridConstraints(7, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        idValueTextField = new JTextField();
        mainPanel.add(idValueTextField, new GridConstraints(7, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        excludeFileLabel = new JLabel();
        excludeFileLabel.setText("Exclude file name contains");
        mainPanel.add(excludeFileLabel, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        exclusionsTextField = new JTextField();
        mainPanel.add(exclusionsTextField, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        playButton = new JButton();
        playButton.setText("Play");
        mainPanel.add(playButton, new GridConstraints(13, 0, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}