package laczo.model;

import javax.swing.*;
import java.nio.file.Path;

/**
 * Created by Andras Laczo 2020. 04. 17.
 */

public class ViewModel {

    private Path sourceDirectoryPath;
    private Path outputFilePath;
    private String idSheetName;
    private String idCellColumn;
    private String idCellRow;
    private String exculdeFileNameLike;
    private DefaultListModel<String> cellListModel = new DefaultListModel<>();

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

    public String getIdCellRow() {
        return idCellRow;
    }

    public void setIdCellRow(String idCellRow) {
        this.idCellRow = idCellRow;
    }

    public String getExculdeFileNameLike() {
        return exculdeFileNameLike;
    }

    public void setExculdeFileNameLike(String exculdeFileNameLike) {
        this.exculdeFileNameLike = exculdeFileNameLike;
    }

    public DefaultListModel<String> getCellListModel() {
        return cellListModel;
    }

    public void setCellListModel(DefaultListModel<String> cellListModel) {
        this.cellListModel = cellListModel;
    }
}
