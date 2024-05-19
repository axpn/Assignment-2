package models;
import utils.Utilities;

public abstract class ComputingDevice extends Technology {
    private int storage;//8<=storage<=128, be divisible by 8
    private String processor;//  <= 20 chars,no default
public ComputingDevice(String modelName, Double price, Manufacturer manufacturer, String id,String processor,int storage){
    super(modelName,price,manufacturer,id);
    this.storage=storage;
    this.processor=processor;
}

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
    if (Utilities.validRange(storage,8,128)&& storage %8==0)
    {  this.storage = storage;}
    }
    public String getProcessor(){
    return processor;
    }
    public void setProcessor(String processor){
    if (Utilities.validStringlength(processor,20)){
        this.processor=processor;
    }
    }
    public String displayCondensed(){return super.getModelName() + super.getPrice   () + super.getManufacturer() + super.getId() + ": ComputingDevice(" + processor + "," + storage + ")";}
    @Override
    public String toString(){
    return "Processor:"+processor+", Storage:"+storage+"GB";
    }
}
