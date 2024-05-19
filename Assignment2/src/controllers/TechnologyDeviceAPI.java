package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.*;

import utils.ISerializer;
import utils.OperatingSystemUtility;

import utils.Utilities;
import models.Technology;
import java.io.*;
import java.util.*;



//TODO - ensure that this class implements iSerializer
public class TechnologyDeviceAPI implements ISerializer{

    //TODO - create 2 fields
    private List<Technology> technologyList=new ArrayList<>();
    private File file;

    //TODO - create constructor
    public TechnologyDeviceAPI(File file) {

    this.file=file;
}
   //TODO - CRUD Methods
   //Create method
    public boolean addTechnologyDevice(Technology technology){
        return technologyList.add(technology);
    }
    //Read method
    public String listAllTechnologyDevice(){
        String str = "";
        for (Technology technology : technologyList){
            str += technologyList.indexOf(technology) + ":" + technology.displayCondensed() + "\n";
        }
        if (str.isEmpty()){
            return "No Technology";
        }
        else {
            return str;
        }
    }
    //Update method
    public Technology findTechnology(int index){
        if (isValidIndex(index)){
            return technologyList.get(index);
        }
        return null;
    }
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < technologyList.size());
    }

    public boolean isValidWearableDeviceIndex(int index) {
        if (isValidIndex(index)) {
            return (technologyList.get(index)) instanceof WearableDevice;
        }
        return false;
    }

    public boolean isValidSmartBandIndex(int index) {
        if (isValidIndex(index)) {
            return (technologyList.get(index)) instanceof SmartBand;
        }
        return false;
    }

    public boolean isValidSmartWatchIndex(int index) {
        if (isValidIndex(index)) {
            return (technologyList.get(index)) instanceof SmartWatch;
        }
        return false;
    }
    public boolean isValidComputingDeviceIndex(int index){
        if (isValidIndex(index)){
            return (technologyList.get(index)) instanceof ComputingDevice;
        }
        return false;
    }
    public boolean isValidTabletIndex(int index){
        if (isValidIndex(index)){
            return (technologyList.get(index)) instanceof Tablet;
        }
        return false;
    }//will be used in Driver class

    public boolean updateWearableDevice(int indexToUpdate,String modelName,double price,Manufacturer manufacturer,String id,String size,String material){
        //find the object by the index number
        Technology foundWearableDevice = findTechnology(indexToUpdate);
        //if the object exists update it
        if ((foundWearableDevice != null) && (foundWearableDevice instanceof WearableDevice)){
            foundWearableDevice.setModelName(modelName);
            foundWearableDevice.setPrice(price);
            foundWearableDevice.setManufacturer(manufacturer);
            foundWearableDevice.setId(id);
            ((WearableDevice) foundWearableDevice).setSize(size);
            ((WearableDevice) foundWearableDevice).setMaterial(material);
            return true;
        }
        return false;//if no object exist
    }
    public boolean updateSmartBand(int indexToUpdate,String modelName,double price,Manufacturer manufacturer,String id,String size,String material,boolean heartRateMonitor){
        Technology foundSmartBand = findTechnology(indexToUpdate);
        if ((foundSmartBand != null) && (foundSmartBand instanceof SmartBand)){
            foundSmartBand.setModelName(modelName);
            foundSmartBand.setPrice(price);
            foundSmartBand.setManufacturer(manufacturer);
            foundSmartBand.setId(id);
            ((SmartBand) foundSmartBand).setSize(size);
            ((SmartBand) foundSmartBand).setMaterial(material);
            ((SmartBand) foundSmartBand).setHeartRateMonitor(heartRateMonitor);
            return true;
        }
        return false;
    }
    public boolean updateSmartWatch(int indexToUpdate,String modelName, double price, Manufacturer manufacturer, String id, String size, String material,String displayType){
        Technology foundSmartWatch = findTechnology(indexToUpdate);
        if ((foundSmartWatch != null) && (foundSmartWatch instanceof SmartWatch)){
            foundSmartWatch.setModelName(modelName);
            foundSmartWatch.setPrice(price);
            foundSmartWatch.setManufacturer(manufacturer);
            foundSmartWatch.setId(id);
            ((SmartWatch) foundSmartWatch).setSize(size);
            ((SmartWatch) foundSmartWatch).setMaterial(material);
            ((SmartWatch) foundSmartWatch).setDisplayType(displayType);
            return true;
        }
        return false;
    }
    public boolean updateComputingDevice(int indexToUpdate,String modelName, Double price, Manufacturer manufacturer, String id,String processor,int storage){
        Technology foundComputingDevice = findTechnology(indexToUpdate);
        if ((foundComputingDevice != null) && (foundComputingDevice instanceof ComputingDevice)){
            foundComputingDevice.setModelName(modelName);
            foundComputingDevice.setPrice(price);
            foundComputingDevice.setManufacturer(manufacturer);
            foundComputingDevice.setId(id);
            ((ComputingDevice) foundComputingDevice).setProcessor(processor);
            ((ComputingDevice) foundComputingDevice).setStorage(storage);
            return true;
        }
        return false;
    }
    public boolean updateTablet(int indexToUpdate,String modelName, Double price, Manufacturer manufacturer, String id,String processor,int storage,String operatingSystem){
        Technology foundTablet = findTechnology(indexToUpdate);
        if ((foundTablet != null) && (foundTablet instanceof Tablet)){
            foundTablet.setModelName(modelName);
            foundTablet.setPrice(price);
            foundTablet.setManufacturer(manufacturer);
            foundTablet.setId(id);
            ((Tablet) foundTablet).setProcessor(processor);
            ((Tablet) foundTablet).setStorage(storage);
            ((Tablet) foundTablet).setOperatingSystem(operatingSystem);
            return true;
        }
        return false;
    }
    //Delete method
    public Technology deleteTechnology(int indexToDelete){
        if (isValidIndex(indexToDelete)) {
            return technologyList.remove((indexToDelete));
        }
        return null;
    }
    //TODO - Number methods
    public int numberOfTechnologyDevices() {
        return technologyList.size();
    }

    public int numberOfSmartWatch(){
        int number =0;
        for(Technology technology: technologyList){
            if(technology instanceof SmartWatch ){
                number++;
            }
        }
        return number;
    }
    public int numberOfSmartBands(){
        int number =0;
        for(Technology technology: technologyList){
            if(technology instanceof SmartBand ){
                number++;
            }
        }
        return number;
    }
    public int numberOfTablets(){
        int number =0;
        for(Technology technology: technologyList){
            if(technology instanceof  Tablet ){
                number++;
            }
        }
        return number;
    }
    public int numberOfTechnologyByChosenManufacturer(Manufacturer  manufacturer){
        int number=0;
        for(Technology technology:technologyList){
            if(technology.getManufacturer().equals(manufacturer)){
                number++;
            }
        }
        return number;
    }

    // TODO Read/list methods
    public Object getTechnologyByIndex(int i) {
    }

    public String listAllTechnologyAbovePrice(double v) {
    }


    //the following is isValidId can be updated
    //to suit your code
    /*public boolean isValidId(String id) {
        for (Technology techDev : technologyList) {
            if (techDev.getId().equals(id))
                return false;
        }
            return true;
        }
*/

    //TODO get Technology methods

    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    //TODO - delete methods



    //TODO - sort methods
    public void sortByPriceDescending(){
        
    }
    public void sortByPriceAscending(){

    }
    public void swapTechnology(List<Technology> technologyList,int i, int j){
        Technology temp =  technologyList.get(i);
        technologyList.set(i,technologyList.get(j));
        technologyList.set(j,temp);
    }//learned from CSDN use"List.set"to swap as Assigning an object reference to another object reference is not allowed.  should swap the positions of the objects in the list directly instead of their references.
    //TODO Top 5 methods
public List<Technology> topFiveMostExpenxiveTablet(){}




    // TODO Persistence methods
    @Override
    public String fileName() {
        return String.valueOf(file);
    }
    public void save() throws Exception{
        var xstream = new XStream(new DomDriver());
        ObjectOutputStream os = xstream.createObjectOutputStream(new FileWriter(file));
        os.writeObject(technologyList);
        os.close();
    }
    public void load() throws Exception{
        Class<?>[] classes = new Class[]{ Technology.class};
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(file));
        technologyList = (List<Technology>) in.readObject();
        in.close();
    }



}
