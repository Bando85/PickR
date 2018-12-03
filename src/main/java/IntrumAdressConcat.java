import java.util.HashMap;

public class IntrumAdressConcat {
    private String address = "";
    private HashMap<Integer, String> addressMap = new HashMap<Integer, String>();

    public void put(ExcelData e) {
        try {
            if (e.getName() == "streetName" && e.getValue()!=null)
                addressMap.put(0, e.getValue().toString());
            if (e.getName() == "streetType" && e.getValue()!=null)
                addressMap.put(1, e.getValue().toString());
            if (e.getName() == "houseNumb" && e.getValue()!=null)
                addressMap.put(2, e.getValue().toString());
            if (e.getName() == "buildNumb" && e.getValue()!=null)
                addressMap.put(3, e.getValue().toString());
            if (e.getName() == "staircaseNumb" && e.getValue()!=null)
                addressMap.put(4, e.getValue().toString());
            if (e.getName() == "floor1" && e.getValue()!=null)
                addressMap.put(5, e.getValue().toString());
            if (e.getName() == "floor2" && e.getValue()!=null)
                addressMap.put(6, e.getValue().toString());
            if (e.getName() == "doorNumb" && e.getValue()!=null)
                addressMap.put(7, e.getValue().toString());
        }
        catch (NullPointerException e1){
            e1.printStackTrace();
        }

    }


    public String getAdress() {
        for (int i=0; i<addressMap.size();i++){
            if (addressMap.get(i)!=null) address = address + " " + addressMap.get(i);
        }

        address = address.replaceAll(".0","");
        return address;
    }
}

