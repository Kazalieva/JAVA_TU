package lab_6;

public class BlackFriday{
    public Electronic [] electronics;
    public Books [] books;

    public static void processSales() {
        ProductLoader productLoader = new ProductLoader();
        try {

            int electronicsCount = 0; int currentIndexElectronics = 0;
            int booksCount = 0; int currentIndexBooks = 0;
            for (Object product : products) {
                if (product instanceof Electronic) {
                    electronicsCount++;
                }
                if (product instanceof Books) {
                    booksCount++;
                }
            }
            electronic = new Electronic[electronicsCount];
            books = new Books[booksCount];
            for (Object product : products) {
                if (product instanceof Electronic) {
                    electronic[currentIndexElectronics] = (Electronic) product;
                    currentIndexElectronics++;
                }
                if (product instanceof Books) {
                    books[currentIndexBooks] = (Books) product;
                    currentIndexBooks++;
                }
            }


        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
