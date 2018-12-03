import java.security.Key;
import java.util.LinkedList;
import java.util.List;

public final class cellListToEData {

    public static List<ExcelData> convert (ListOfCells rawList) {
        List<ExcelData> outList = new LinkedList<ExcelData>();
        for (Integer i : rawList.getCellList().keySet()) {
            if (i != null) {
                ExcelData eDataCell = new ExcelData();
                eDataCell.setRow(rawList.getCellList().get(i).getRow());
                eDataCell.setCol(rawList.getCellList().get(i).getCol());
                eDataCell.setSheetname(rawList.getCellList().get(i).getSheetName());
                outList.add(eDataCell);
            }
        }
        return outList;
    }
}
