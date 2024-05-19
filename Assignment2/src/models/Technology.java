package models;
import utils.Utilities;
public abstract class Technology {
    private String modelName ; //should be max 30 characters    no default value
    private double price = 20; //must be >= 20   default value 20
    private Manufacturer manufacturer;
    private String id = "unknown";//should be max 10 characters   default value "unknown"
    public Technology(String modelName, Double price, Manufacturer manufacturer, String id){
        this.modelName = Utilities.truncateString(modelName,30);//restrictions if the modelName is over 30 characters,it will be truncated to 30 characters
        this.price = price;//restrictions will be added in setter method
        this.manufacturer = manufacturer;
        this.id = Utilities.truncateString(id,10);//restrictions if the id is over 10 characters,it  will be truncated to 10 characters
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (Utilities.validRange(price,20)){
            this.price = price;
        }
    }//restrictions the price must be >= 20 and the Utilities method is newly written

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getManufacturerName(){
        return manufacturer.getManufacturerName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String display(){
        return (modelName + "\n" + price + "\n" + manufacturer + "\n" + id + "\n");
    }
    public abstract  double getInsurancePremium();
    public abstract String connectToInternet();
    public abstract String displayCondensed();//to list all technology values    learned from the code of SocialNetWorkV9.0
    @Override
    public String toString() {
        return "Technology{" + "modelName= " + modelName + ", price=" + price + ", manufacturer=" + manufacturer + ", id= " + id + '}';
    }
}
