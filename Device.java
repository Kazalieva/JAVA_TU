package lab7;

import java.util.Scanner;

public class Device {
    String marka;
    String model;
    double price;

    Scanner scanner = new Scanner(System.in);

    public Device(String marka,String model,double price) {
        this.marka = marka;
        this.model = model;
        this.price = price;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
