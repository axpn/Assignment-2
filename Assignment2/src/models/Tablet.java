package models;

import utils.OperatingSystemUtility;

public class Tablet extends ComputingDevice {

    private String operatingSystem="Windows";
    public Tablet(String modelName, Double price, Manufacturer manufacturer, String id,String processor,int storage,String operatingSystem) {
        super(modelName,price,manufacturer,id,processor,storage);
this.operatingSystem=operatingSystem;
    }
    @Override
    public double getInsurancePremium(){
        return getPrice()*.01;
    }
@Override
    public String connectToInternet(){
        return "Connects to the internet via Wi-Fi";
}
public String getOperatingSystem(){
return operatingSystem;
}

    public void setOperatingSystem(String operatingSystem) {
        if(OperatingSystemUtility.isValidOperatingSystem(operatingSystem)){
            this.operatingSystem=operatingSystem;
        }
    }
    public String toString(){
        return "Operating System:"+operatingSystem+", Insurance Premium: €"+getInsurancePremium();
    }
}
