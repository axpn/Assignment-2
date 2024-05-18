package models;

import utils.Utilities;

public  class SmartBand extends WearableDevice{


    public void setHeartRateMonitor(boolean heartRateMonitor) {
        this.heartRateMonitor = heartRateMonitor;
    }

    private boolean heartRateMonitor;
    public SmartBand(String modelName,double price,Manufacturer manufacturer,String id,String size,String material){
        super(modelName, price, manufacturer, id,size,material);
    }

    @Override
    public double getInsurancePremium() {
        return getPrice()*0.07;
    }

    @Override
    public String connectToInternet() {
        return "Connects to the internet via Companion App";
    }
    @Override
    public String toString() {
        if(heartRateMonitor=true){
            return "smartband{" + "InsurancePremium" + getInsurancePremium() + "connectToInternet" + connectToInternet() + "Includes Heart Rate Monitor" +"WearableDevice{" +
                    "size='" + getSize() + '\'' +
                    ", material='" + getMaterial() + '\'' +
                    '}';
        }else {
            return "smartband{" + "InsurancePremium" + getInsurancePremium() + "connectToInternet" + connectToInternet() + "not Includes Heart Rate Monitor" + "WearableDevice{" +
                    "size='" + getSize()+ '\'' +
                    ", material='" + getMaterial() + '\'' +
                    '}';
        }

    }
    public boolean isHeartRateMonitor(){
        return true;

    }
}

