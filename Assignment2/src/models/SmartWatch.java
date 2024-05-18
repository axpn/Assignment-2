package models;
import utils.Utilities;
public  class  SmartWatch extends WearableDevice{

    public SmartWatch(String modelName, double price, Manufacturer manufacturer, String id, String size, String material) {
        super(modelName, price, manufacturer, id, size, material);
    }

    public String getDisplaytype() {
        return displaytype;
    }

    public void setDisplaytype(String displaytype) {
        if (displaytype=="LCD") {
            this.displaytype = displaytype;
        }else if(displaytype=="LED") {
            this.displaytype = displaytype;
        }
        if (displaytype=="TFT") {
            this.displaytype = displaytype;
        }else if(displaytype=="AMOLED") {
            this.displaytype = displaytype;
        }
    }

    private String displaytype="LCD";


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
                    '}'+"displaytype"+getDisplaytype();

        }

    }

