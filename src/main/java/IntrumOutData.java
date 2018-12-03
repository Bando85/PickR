import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.util.ArrayList;
import java.util.List;

public class IntrumOutData {


    public List<ExcelData> getData() {

        List<ExcelData> intrumList = new ArrayList<>();

        ExcelData valType = new ExcelData();
        valType.setName("valType");
        valType.setCol(6);
        intrumList.add(valType);

        ExcelData orderDate = new ExcelData();
        orderDate.setName("orderDate");
        orderDate.setCol(1);
        intrumList.add(orderDate);

        ExcelData pcode = new ExcelData();
        pcode.setName("pcode");
        pcode.setCol(2);
        intrumList.add(pcode);

        ExcelData town = new ExcelData();
        town.setName("town");
        town.setCol(3);
        intrumList.add(town);

        ExcelData address = new ExcelData();
        address.setName("address");
        address.setCol(4);
        address.setValueType(CellType.STRING);
        intrumList.add(address);

        ExcelData plotNumb = new ExcelData();
        plotNumb.setName("plotNumb");
        plotNumb.setCol(5);
        intrumList.add(plotNumb);

        return intrumList;
    }
}
