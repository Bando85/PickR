package laczo.model;

import org.apache.poi.xssf.usermodel.XSSFCell;

import java.nio.file.Path;
import java.util.LinkedList;

/**
 * Created by Andras Laczo 2020. 04. 19.
 */

public class RowFromFile {
    private Path fileName;
    private LinkedList<RawCellObject> cells;


    public RowFromFile() {
        this.cells = new LinkedList<>();
    }

    public Path getFileName() {
        return fileName;
    }

    public void setFileName(Path fileName) {
        this.fileName = fileName;
    }

    public void addCell(RawCellObject cell) {
        this.cells.add(cell);
    }

    public LinkedList<RawCellObject> getCells() {
        return cells;
    }

    public void setCells(LinkedList<RawCellObject> cells) {
        this.cells = cells;
    }

}
