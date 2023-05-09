package lab_6;

public class Provider implements ValidatePhone {
    String name;
    String number;

    public Provider(String name,String number){
        this.name = name;
        this.number = number;

        try {
            if (ValidatePhone.validatePhoneNumber(number)) {
                this.number = number;
            }
        }catch (WrongPhoneNumberException e){
            e.getMessage();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", phone='" + number + '\'' +
                '}';
    }
}
