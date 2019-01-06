import java.util.ArrayList;
import java.util.List;

public class IntrumData {

    public List<ExcelData> getConstList() {

        List<ExcelData> intrumList = new ArrayList<>();

            ExcelData valType = new ExcelData();
            valType.setName("valType");
            valType.setRow(11);
            valType.setCol(8);
            intrumList.add(valType);

            ExcelData orderDate = new ExcelData();
            orderDate.setName("orderDate");
        orderDate.setRow(11);
        orderDate.setCol(32);
        intrumList.add(orderDate);

            ExcelData pcode = new ExcelData();
            pcode.setName("pcode");
        pcode.setRow(22);
        pcode.setCol(6);
        intrumList.add(pcode);

            ExcelData town = new ExcelData();
            town.setName("town");
        town.setRow(22);
        town.setCol(24);
        intrumList.add(town);

            ExcelData streetName = new ExcelData();
            streetName.setName("streetName");
        streetName.setRow(24);
        streetName.setCol(6);
        intrumList.add(streetName);

            ExcelData streetType = new ExcelData();
            streetType.setName("streetType");
        streetType.setRow(24);
        streetType.setCol(18);
        intrumList.add(streetType);

            ExcelData houseNumb = new ExcelData();
            houseNumb.setName("houseNumb");
        houseNumb.setRow(24);
        houseNumb.setCol(23);
        intrumList.add(houseNumb);

            ExcelData buildNumb = new ExcelData();
            buildNumb.setName("buildNumb");
        buildNumb.setRow(24);
        buildNumb.setCol(25);
        intrumList.add(buildNumb);

            ExcelData staircaseNumb = new ExcelData();
            staircaseNumb.setName("staircaseNumb");
        staircaseNumb.setRow(24);
        staircaseNumb.setCol(27);
        intrumList.add(staircaseNumb);

            ExcelData floor1 = new ExcelData();
            floor1.setName("floor1");
        floor1.setRow(24);
        floor1.setCol(29);
        intrumList.add(floor1);

            ExcelData floor2 = new ExcelData();
            floor2.setName("floor2");
        floor2.setRow(24);
        floor2.setCol(33);
        intrumList.add(floor2);

            ExcelData doorNumb = new ExcelData();
            doorNumb.setName("doorNumb");
        doorNumb.setRow(24);
        doorNumb.setCol(35);
        intrumList.add(doorNumb);

            ExcelData plotNumb = new ExcelData();
            plotNumb.setName("plotNumb");
        plotNumb.setRow(30);
        plotNumb.setCol(26);
        intrumList.add(plotNumb);

        //all member get the same sheet name
        for (ExcelData e:intrumList){
            e.setSheetName("ADATLAP");
        }

        return intrumList;

    }
}

