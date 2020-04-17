package laczo.view;

import laczo.model.ListOfCells;
import javax.swing.*;

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
}