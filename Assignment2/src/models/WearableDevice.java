package models;
import utils.Utilities;
public abstract class WearableDevice extends Technology{
    private String size;//should be less than 20 chars   no default value
    private String material;//should be less than 10 chars   no default value
    public WearableDevice(String modelName,double price,Manufacturer manufacturer,String id,String size,String material){
        super(modelName, price, manufacturer, id);
        this.size = size;
        this.material = material;// restrictions will be written in setter method
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (Utilities.validStringlength(size,20)) {
            this.size = size;
        }
    }//should be less than 20 chars

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (Utilities.validStringlength(material,10)) {
            this.material = material;
        }
    }//should be less than 10 chars
    public String diaplayCondensed(){
        return super.getModelName() + super.getPrice   () + super.getManufacturer() + super.getId() + ": WearableDevice(" + size + "," + material + ")";
    }

    @Override
    public String toString() {
        return "WearableDevice{" +
                "size='" + size + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
