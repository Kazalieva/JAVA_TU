package lab_6;


/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductLoader implements ImportDate {



    public Object[] importDataFromFile() throws IOException {
        Object[] result = new Object[getNumberOfRows()];
        BufferedReader bufferedReader = new BufferedReader(new FileReader("salesproducts.txt"));
        int index = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split("#");
            switch (data[0]) {
                case "1":
                    Electronic electronics = null;
                    try {
                        electronics = new Electronic(data[3], Double.parseDouble(data[4]), Integer.parseInt(data[5]),
                                new Provider(data[1], data[2]), data[6], data[7]);
                    } catch (WrongPhoneNumberException e) {
                        System.err.println(e.getMessage());
                    }
                    result[index] = electronics;
                    index++;
                    break;
                case "2":
                    Books book = null;
                    try {
                        book = new Books(, Double.parseDouble(data[4]), Integer.parseInt(data[5]),
                                new Provider(data[1], data[2]), data[6], data[7]);
                    } catch (WrongPhoneNumberException e) {
                        System.err.println(e.getMessage());
                    }
                    result[index] = book;
                    index++;
                    break;
            }
        }
        bufferedReader.close();
        return result;
    }

    private int getNumberOfRows() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("salesproducts.txt"));
        int lines = 0;
        while (bufferedReader.readLine() != null) {
            lines++;
        }
        bufferedReader.close();
        return lines;
    }
}
*/
