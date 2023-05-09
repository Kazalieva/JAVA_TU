package lab_6;

public class Electronic extends Product{
    String manufacturer;
    String model;


    public Electronic(int inventoryNumber, double price, double quantity, String provider,String manufacturer,String model) {
        super(inventoryNumber, price, quantity, provider);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public double getPromotionalPrice() {
        return this.getPrice() - this.getPrice()*10/100;
    }
    public boolean sellProduct(int quantity) throws NoMoreProductsException {
        if(this.getQuantity() >= quantity){
            this.setQuantity(this.getQuantity() - quantity);
            return true;
        }else {
            throw new NoMoreProductsException();
        }
    }

}
