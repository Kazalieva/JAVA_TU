package lab7;

public class BrokenDevice extends Device {
    String symptoms;
    int days;


    public BrokenDevice(String marka, String model, double price,String symptoms,int days) {
        super(marka, model, price);
        this.days= days;
        this.symptoms = symptoms;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
