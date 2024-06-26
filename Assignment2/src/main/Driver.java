/**
 * Author:Yi Zhang,Chi Ma,Yunpeng Bai
 * Yi Zhang:finished the Technology class and WearableDevice class;finished the WearableDeviceTest class
 *          write the CRUD method and valid method in TechnologyDeviceAPI class ;write the Technology Store Menu.
 * ChiMa:finished the computing device class and tablet class;finshed the save and load method in TechnologyDeviceAPI class and Driver class;finished the number methods and sort methods in TechnologyDeviceAPI class;
 *       finshed the technologyReportMenu ,sortMenu(),runSortMenu(),listAllSmartWatches(),listAllTablets(),listAllTechnologyBelowPrice,listAllTechDevicesByChosenManufacturer, getManufacturerName(),write some test codes inTechnologyDeviceAPITest.
 * Bai Yunpeng  finish Smartband and Smartwatch method in controll      Smartband and Smartwatchtest
 **/
package main;

import controllers.ManufacturerAPI;
import controllers.TechnologyDeviceAPI;

import models.*;
import utils.ScannerInput;
import utils.Utilities;

import java.io.File;

public class Driver {


    private TechnologyDeviceAPI techAPI;
    private ManufacturerAPI manufacturerAPI;


    public static void main(String[] args) throws Exception {
        new Driver().start();
    }

    public void start() {

        manufacturerAPI = new ManufacturerAPI(new File("manufacturers.xml"));
        //TODO - construct fields

        //TODO - load all data once the serializers are set up

        runMainMenu();
    }

    private int mainMenu() {
        System.out.println("""
                 -------Technology Store-------------
                |  1) Manufacturer CRUD MENU     |
                |  2) Technology  CRUD MENU      |
                |  3) Reports MENU               |
                |--------------------------------|
                |  4) Search Manufacturers       |
                |  5) Search Technology Devices  |  
                |  6) Sort Technology Devices    | 
                |--------------------------------|
                |  10) Save all                  |
                |  11) Load all                  |
                |--------------------------------|
                |  0) Exit                       |
                 --------------------------------""");
        return ScannerInput.readNextInt("==>> ");
    }

    //// search todo by different criteria i.e. look at the list methods and give options based on that.
// sort todo (and give a list of options - not a recurring menu thou)
    private void runMainMenu() {
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> runManufacturerMenu();
                //TODO - Add options
                case 2 -> runtechAPIMenu();
                case 3 -> runReportsMenu();
                case 4 -> searchManufacturer();
                case 5 -> searchTechnologyDevice();
                case 6 -> sortMenu();
                case 11 -> saveAll();
                case 12 -> loadAll();
                default -> System.out.println("Invalid option entered" + option);
            }
            ScannerInput.readNextLine("\n Press the enter key to continue");
            option = mainMenu();
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }

    private void exitApp() {
        //TODO - save all the data entered
        System.out.println("Exiting....");
        System.exit(0);
    }

    //----------------------
    //  Manufacturer Menu Items
    //----------------------
    private int manufacturerMenu() {
        System.out.println("""
                 --------Manufacturer Menu---------
                |  1) Add a manufacturer           |
                |  2) Delete a manufacturer        |
                |  3) Update manufacturer details  |
                |  4) List all manufacturers       |
                |  5) Find a manufacturer          |
                |  0) Return to main menu          |
                 ----------------------------------""");
        return ScannerInput.readNextInt("==>>");
    }

    private void runManufacturerMenu() {
        int option = manufacturerMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> addManufacturer();
                case 2 -> deleteManufacturer();
                case 3 -> updateManufacturer();
                case 4 -> System.out.println(manufacturerAPI.listManufacturers());
                case 5 -> findManufacturer();
                case 6 -> listByManufacturerName();
                default -> System.out.println("Invalid option entered" + option);
            }
            ScannerInput.readNextLine("\n Press the enter key to continue");
            option = manufacturerMenu();
        }
    }

    private void addManufacturer() {
        String manufacturerName = ScannerInput.readNextLine("Please enter the manufacturer name: ");
        int manufacturerNumEmployees = ScannerInput.readNextInt("Please enter the number of employees: ");

        if (manufacturerAPI.addManufacturer(new Manufacturer(manufacturerName, manufacturerNumEmployees))) {
            System.out.println("Add successful");
        } else {
            System.out.println("Add not successful");
        }
    }

    private void deleteManufacturer() {
        String manufacturerName = ScannerInput.readNextLine("Please enter the manufacturer name: ");
        if (manufacturerAPI.removeManufacturerByName(manufacturerName) != null) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Delete not successful");
        }
    }

    private void updateManufacturer() {
        Manufacturer manufacturer = getManufacturerByName();
        if (manufacturer != null) {
            int numEmployees = ScannerInput.readNextInt("Please enter number of Employees: ");
            if (manufacturerAPI.updateManufacturer(manufacturer.getManufacturerName(), numEmployees))
                System.out.println("Number of Employees Updated");
            else
                System.out.println("Number of Employees NOT Updated");
        } else
            System.out.println("Manufacturer name is NOT valid");
    }

    private void findManufacturer() {
        Manufacturer developer = getManufacturerByName();
        if (developer == null) {
            System.out.println("No such manufacturer exists");
        } else {
            System.out.println(developer);
        }
    }

    private void listByManufacturerName() {
        String manufacturer = ScannerInput.readNextLine("Enter the manufacturer's name:  ");

        System.out.println(manufacturerAPI.listAllByManufacturerName(manufacturer));
    }


    //---------------------
    //  Tech Store Menu
    //---------------------

    private int techAPIMenu() {
        System.out.println(""" 
                 -----Technology Store Menu----- 
                | 1) Add a Tech Device           |
                | 2) Delete a Tech Device        |
                | 3) List all Tech Devices       |
                | 4) Update Tech Device          |
                | 0) Return to main menu         |
                 ----------------------------""");
        return ScannerInput.readNextInt("==>>");
    }

    private void runtechAPIMenu() {
        int option = techAPIMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> addTechDevice();
                case 2 -> deleteTechDevice();
                case 3 -> System.out.println(techAPI.listAllTechnologyDevices());
                case 4 -> updateTechDevice();
                default -> System.out.println("Invalid option entered" + option);
            }
            ScannerInput.readNextLine("\n Press the enter key to continue");
            option = techAPIMenu();
        }
    }

    private void addTechDevice() {
        String modelName = ScannerInput.readNextLine("Please enter the model name");
        double price = ScannerInput.readNextDouble("Please enter the price");
        String id = ScannerInput.readNextLine("Please enter the id");
    }

    private void deleteTechDevice() {
        System.out.println(techAPI.listAllTechnologyDevices());
        int indexToDelete = ScannerInput.readNextInt("Enter the index of the tech device to delete");
        Technology technologyToDelete = techAPI.deleteTechnology(indexToDelete);
        if (technologyToDelete != null) {
            System.out.println("Delete Successfully! Delete technology: " + technologyToDelete.display());
        } else {
            System.out.println("Delete NOT Successfully");
        }
    }

    private void updateTechDevice() {
        if (techAPI.numberOfTechnologyDevices() > 0) {
            boolean isUpdated = false;
            int option = ScannerInput.readNextInt("""
                    ---------------------------------
                    |   1) Update a Smart Watch
                    |   2) Update a Smart Band
                    |   3) Update a Tablet
                    ----------------------------------
                    ==>> """);
            switch (option) {
                case 1 -> {
                    System.out.println(techAPI.listAllTechnologyDevices());
                    if (techAPI.numberOfSmartWatch() > 0) {
                        int smartWatchIndex = ScannerInput.readNextInt("Enter the index of the watch to update");
                        if (techAPI.isValidSmartWatchIndex(smartWatchIndex)) {
                            String modelName = ScannerInput.readNextLine("Enter the model name: ");
                            double price = ScannerInput.readNextDouble(" Enter the model price: ");
                            String id = ScannerInput.readNextLine("Enter the model id: ");
                            String size = ScannerInput.readNextLine("Enter the model size: ");
                            String material = ScannerInput.readNextLine("Enter the model material: ");
                            String displayType = ScannerInput.readNextLine("Enter the model display type: ");
                            String manufactureName = ScannerInput.readNextLine("Enter the manufacture name");
                            int numEmployees = ScannerInput.readNextInt("Enter the num of the employees");
                            Manufacturer manufacturer = new Manufacturer(manufactureName, numEmployees);
                            isUpdated = techAPI.updateSmartWatch(smartWatchIndex, modelName, price, manufacturer, id, size, material, displayType);
                        }
                    }
                }
                case 2 -> {
                    System.out.println(techAPI.listAllTechnologyDevices());
                    if (techAPI.numberOfSmartBands() > 0) {
                        int smartBandIndex = ScannerInput.readNextInt("Enter the index of the watch to update");
                        if (techAPI.isValidSmartWatchIndex(smartBandIndex)) {
                            String modelName = ScannerInput.readNextLine("Enter the model name: ");
                            double price = ScannerInput.readNextDouble(" Enter the model price: ");
                            String id = ScannerInput.readNextLine("Enter the model id: ");
                            String size = ScannerInput.readNextLine("Enter the model size: ");
                            String material = ScannerInput.readNextLine("Enter the model material: ");
                            char isMonitored = ScannerInput.readNextChar("Is this band is monitored");
                            boolean heartRateMonitor = Utilities.YNtoBoolean(isMonitored);
                            String manufactureName = ScannerInput.readNextLine("Enter the manufacture name");
                            int numEmployees = ScannerInput.readNextInt("Enter the num of the employees");
                            Manufacturer manufacturer = new Manufacturer(manufactureName, numEmployees);
                            isUpdated = techAPI.updateSmartBand(smartBandIndex, modelName, price, manufacturer, id, size, material, heartRateMonitor);
                        }
                    }
                }
                case 3 -> {
                    System.out.println(techAPI.listAllTechnologyDevices());
                    if (techAPI.numberOfTablets() >= 0) {
                        int tabletIndex = ScannerInput.readNextInt("Enter the index of the tablet to update");
                        if (techAPI.isValidTabletIndex(tabletIndex)) {
                            String modelName = ScannerInput.readNextLine("Enter the model name: ");
                            double price = ScannerInput.readNextDouble(" Enter the model price: ");
                            String id = ScannerInput.readNextLine("Enter the model id: ");
                            String processor = ScannerInput.readNextLine("Enter the processor: ");
                            int storage = ScannerInput.readNextInt("Enter the model storage: ");
                            String operatingSystem = ScannerInput.readNextLine("Enter the operating system:");
                            String manufactureName = ScannerInput.readNextLine("Enter the manufacture name");
                            int numEmployees = ScannerInput.readNextInt("Enter the num of the employees");
                            Manufacturer manufacturer = new Manufacturer(manufactureName, numEmployees);
                            isUpdated = techAPI.updateTablet(tabletIndex, modelName, price, manufacturer, id, processor, storage, operatingSystem);
                        }
                    }
                }
            }
        }
    }


            public void runReportsMenu () {
                int option = reportsMenu();
                while (option != 0) {
                    switch (option) {
                        case 1 -> runManufacturerReports();
                        case 2 -> System.out.println("TODO - case 2");
                        default -> System.out.println("Invalid option entered" + option);
                    }
                    ScannerInput.readNextLine("\n Press the enter key to continue");
                    option = reportsMenu();
                }
            }
            private int reportsMenu () {
                System.out.println(""" 
                         --------Reports Menu ---------
                        | 1) Manufacturers Overview    | 
                        | 2) Technology Overview       |
                        | 0) Return to main menu       | 
                          -----------------------------  """);
                return ScannerInput.readNextInt("==>>");
            }

            private int manufacturerReportsMenu () {
                System.out.println(""" 
                         ---------- Manufacturers Reports Menu  -------------
                        | 1) List Manufacturers                              | 
                        | 2) List Manufacturers from a given manufacturer    |
                        | 3) List Manufacturers by a given name              |
                        | 0) Return to main menu                             | 
                          ---------------------------------------------------  """);
                return ScannerInput.readNextInt("==>>");
            }
            public void runManufacturerReports () {
                int option = manufacturerReportsMenu();
                while (option != 0) {
                    switch (option) {
                        case 1 -> System.out.println(manufacturerAPI.listManufacturers());
                        case 2 -> System.out.println("todo - Case 2");
                        case 3 -> System.out.println("todo - Case 3");
                        default -> System.out.println("Invalid option entered" + option);
                    }
                    ScannerInput.readNextLine("\n Press the enter key to continue");
                    option = manufacturerReportsMenu();
                }
            }
    public int technologyReportMenu(){
        System.out.println(""" 
                ---------- Technology Reports Menu  -----------------
               | 1) List all technology                             | 
               | 2) List all SmartBands                             |
               | 3) List all Smart watch                            |
               | 4) List all Tablets                                |
               | 5) List all devices above a price                  |
               | 6) List all devices below a price                  |
               | 7) List all Tablets by operating system            |
               | 8) List all techdevice by a chosen manufacturer    | 
               | 9) List the top five most expensive technology     |
               | 10) List the top five most expensive smart watches |
               | 11) List the top five most expensive tablets       |
               | 0) Return to main menu                             | 
                 ---------------------------------------------------  """);
        return ScannerInput.readNextInt("==>>");
    }
    public void runTechnologyReports(){
        int option = technologyReportMenu();
        while(option !=0){
            switch(option){
                case 1-> System.out.println(techAPI.listAllTechnologyDevices());
                case 2-> System.out.println(techAPI.listAllSmartBands());
                case 3-> System.out.println(techAPI.listAllSmartWatches());
                case 4-> System.out.println(techAPI.listAllTablets());
                case 5-> System.out.println(techAPI.listAllTechnologyAbovePrice());
                case 6-> System.out.println(techAPI.listAllTechnologyBelowPrice());
                case 7-> System.out.println(techAPI.listAllTabletsByOpertingSystem());
                case 8-> System.out.println(techAPI.listAllTechDevicesByChosenManufacturer());
                case 9-> System.out.println(techAPI.topFiveMostExpensiveTechnology());
                case 10-> System.out.println(techAPI.topFiveMostExpensiveSmartWatch());
                case 11-> System.out.println(techAPI.topFiveMostExpensiveTablet());
                default->  System.out.println("Invalid option entered" + option);
            }
            ScannerInput.readNextLine("\n Press the enter key to continue");
            option =  technologyReportMenu();
        }
    }

    public int sortMenu(){
        System.out.println(""" 
                         --------Sort Menu ------------
                        | 1) sortByPriceDescending     | 
                        | 2) sortByPriceAscending      |
                        | 0) Return to main menu       | 
                          -----------------------------  """);
        return ScannerInput.readNextInt("==>>");
    }
    public void runSortMenu(){
        int option = sortMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> System.out.println(techAPI.sortByPriceDescending());
                case 2 -> System.out.println(techAPI.sortByPriceAscending());
                default -> System.out.println("Invalid option entered" + option);
            }
            ScannerInput.readNextLine("\n Press the enter key to continue");
            option = sortMenu();
        }
}
public void searchManufacturer(){
    System.out.println("find a manufacturer by name");

        String name =ScannerInput.readNextLine("Please enter the name of the manufacturer you choose");
        System.out.println(manufacturerAPI.getManufacturerByName(name));

}
    public void searchTechnologyDevice(){
        System.out.println("find a TecDevice by index");
        int index = ScannerInput.readNextInt("Please enter the index of the TechDevice you choose");
        System.out.println(techAPI.getTechnologyByIndex(index));
    }
//todo update methods counting methods


            //---------------------
            //  General Menu Items
            //---------------------

//TODO - write all the methods that are called from your menu

            //---------------------
            //  Helper Methods
            //---------------------

//TODO- write any helper methods that are required


            private Manufacturer getManufacturerByName () {
                String manufacturerName = ScannerInput.readNextLine("Please enter the manufacturer's name: ");
                if (manufacturerAPI.isValidManufacturer(manufacturerName)) {
                    return manufacturerAPI.getManufacturerByName(manufacturerName);
                } else {
                    return null;
                }
            }

    private void saveAll(){
        try {
            System.out.println("Saving to file:"+ manufacturerAPI.fileName());
            System.out.println("Saving to file:"+ techAPI.fileName());
            manufacturerAPI.save();
            techAPI.save();
        }catch (Exception e){
            System.err.println("Error writing to file:"+e);
        }
    }
    private void loadAll(){
        try {
            System.out.println("Loading from file:"+ manufacturerAPI.fileName());
            System.out.println("Loading from file:"+ techAPI.fileName());
            manufacturerAPI.load();
            techAPI.load();
        }catch (Exception e){
            System.err.println("Error reading from file:"+e);
        }
    }}
