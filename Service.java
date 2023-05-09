package lab7;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Service implements Serializable {
    private List<Device> devices;
    private List<BrokenDevice> brokenDevices;

    public Service() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public Service(List<Device> devices, List<BrokenDevice> brokenDevices) {
        this.devices = devices;
        this.brokenDevices = brokenDevices;
    }
/*
    public void writeToFile(ArrayList<Device>devices,ArrayList<BrokenDevice> brokenDevices){
        try(FileOutputStream fileOut = new FileOutputStream("devices.ser"));
    }
    FileOutputStream fileOut = new FileOutputStream("devices.ser");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(Device device);
    out.close(); fileOut.close();
*/


    public String Info(){
        for(BrokenDevice brokenDevice: brokenDevices){
            System.out.printf("Broken device: %s,%s,%f, symptom -> %s ",brokenDevice.getMarka(),brokenDevice.getModel(),brokenDevice.getPrice(),brokenDevice.getSymptoms());
        }
        System.out.println("-------------------------------------");
        for(Device device : devices){
            System.out.printf("Device: %s,%s,%f",device.getMarka(),device.getModel(),device.getPrice());
        }
        return "This are all devices!";
    }
    public boolean AddNewItem(Device device) {
        if (device == null) {
            return false;
        }
        devices.add(device);
        return true;
    }

    public boolean AddBrokenDevice(BrokenDevice device){
        if (device == null){
            return false;
        }
        brokenDevices.add(device);
        return true;
    }

    public void ReturnBrokenToDevices(BrokenDevice device){
        if(brokenDevices.contains(device)){
            brokenDevices.remove(device);
            System.out.printf("The device {%s} is ready for use!",device.getModel());
            devices.add(new Device(device.getMarka(),device.getModel(),device.getPrice()));
        }
        System.out.println("The device is not fix!");
    }

    public void DevicesWithSameSymptoms(String symptom){
        for (BrokenDevice brokenDevice: brokenDevices){
            if(brokenDevice.getSymptoms().equals(symptom)){
                System.out.println(brokenDevice.getModel() + "has symptom "+symptom);
            }
        }
    }

    public double PriceForAllProducts(){
        double total = 0;
        double devicePr = 0;
        double brokenPr = 0;
        for (Device device : devices){
            devicePr += device.getPrice();
        }
        for (BrokenDevice brokenDevice : brokenDevices){
            brokenPr +=brokenDevice.getPrice();
        }

        total = devicePr + brokenPr;
        return total;
    }

    public double Profit(double priceForDay){
        int totalDays = 0;
        for (BrokenDevice brokenDevice : brokenDevices){
            totalDays += brokenDevice.getDays();
        }
        System.out.println("The profit will be: ");
        return totalDays*priceForDay;
    }
}
