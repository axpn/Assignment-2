package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.*;

import utils.ISerializer;
import utils.OperatingSystemUtility;

import utils.Utilities;

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
            str += technologyList.indexOf(technology) + ":" + technology.
        }
    }



    //TODO - Number methods
    public int numberOfTechnologyDevices() {
    }

    // TODO Read/list methods
    public Object getTechnologyByIndex(int i) {
    }
    public String listAllTechnologyDevices() {
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
    public void sortByPriceDescending() {
    }
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
