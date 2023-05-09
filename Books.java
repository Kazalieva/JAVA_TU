package lab_6;

public class Books extends Product{
    String author;
    String title;


    public Books(int inventoryNumber, double price, double quantity, String provider,String author,String title) {
        super(inventoryNumber, price, quantity, provider);
        this.author = author;
        this.title = title;
    }
    public boolean sellProduct(int quantity) throws NoMoreProductsException {
        if(this.getQuantity() >= quantity){
            this.setQuantity(this.getQuantity() - quantity);
            return true;
        }else {
            throw new NoMoreProductsException();
        }
    }
    public double getPromotionalPrice() {
        return this.getPrice()*0.5;
    }
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
