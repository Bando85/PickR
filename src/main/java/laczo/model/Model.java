package laczo.model;

import javax.swing.*;
import java.nio.file.Path;

/**
 * Created by Andras Laczo 2020. 04. 17.
 */

public class Model {

    private Path sourceDirectoryPath;
    private Path outputFilePath;
    private String idSheetName;
    private String idCellColumn;
    private int idCellRow;
    private String idValue;
    private String exculdeFileNameLike;
    private DefaultListModel<String> cellListViewModel = new DefaultListModel<>();
    private ListOfCells listOfCells = new ListOfCells();

    public Path getSourceDirectoryPath() {
        return sourceDirectoryPath;
    }

    public void setSourceDirectoryPath(Path sourceDirectoryPath) {
        this.sourceDirectoryPath = sourceDirectoryPath;
    }

    public Path getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(Path outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public String getIdSheetName() {
        return idSheetName;
    }

    public void setIdSheetName(String idSheetName) {
        this.idSheetName = idSheetName;
    }

    public String getIdCellColumn() {
        return idCellColumn;
    }

    public void setIdCellColumn(String idCellColumn) {
        this.idCellColumn = idCellColumn;
    }

    public Integer getIdCellRow() {
        return idCellRow;
    }

    public void setIdCellRow(Integer idCellRow) {
        this.idCellRow = idCellRow;
    }

    public String getExculdeFileNameLike() {
        return exculdeFileNameLike;
    }

    public void setExculdeFileNameLike(String exculdeFileNameLike) {
        this.exculdeFileNameLike = exculdeFileNameLike;
    }

    public DefaultListModel<String> getCellListViewModel() {
        return cellListViewModel;
    }

    public void setCellListViewModel(DefaultListModel<String> cellListViewModel) {
        this.cellListViewModel = cellListViewModel;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

    public ListOfCells getListOfCells() {
        return listOfCells;
    }

    public void setListOfCells(ListOfCells listOfCells) {
        this.listOfCells = listOfCells;
    }
}
