package models;
import utils.Utilities;
public  class  SmartWatch extends WearableDevice{

    public SmartWatch(String modelName, double price, Manufacturer manufacturer, String id, String size, String material) {
        super(modelName, price, manufacturer, id, size, material);
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        if (displayType=="LCD") {
            this.displayType = displayType;
        }else if(displayType=="LED") {
            this.displayType = displayType;
        }
        if (displayType=="TFT") {
            this.displayType = displayType;
        }else if(displayType=="AMOLED") {
            this.displayType = displayType;
        }
    }

    private String displayType="LCD";


    @Override
    public double getInsurancePremium() {
        return  getPrice()*0.06;
    }

    @Override
    public String connectToInternet() {
        return "Connects to the internet via bluetooth";
    }
    @Override
    public String toString() {

            return "smartwatch{" + "InsurancePremium" + getInsurancePremium() + "connectToInternet" + connectToInternet() + "Includes Heart Rate Monitor" +"WearableDevice{" +
                    "size='" + getSize() + '\'' +
                    ", material='" + getMaterial() + '\'' +
                    '}'+"displaytype"+getDisplayType();

        }

    }

