package lab_6;

/*
Създайте клас Доставчик (Provider) с член-променливи име (name) и телефонен номер  (phoneNumber).
Създайте  клас  Продукт  (Product)  с  член-променливи, съдържащи  информация  за:  инвентарен  номер  (inventoryNumber),
цена  (price), количество (quantity) и доставчик (provider). Класът Product трябва да съдържа два абстрактни метода -
double getPromotionalPrice(), който връща промоционална цена при даден процент намаление и boolean  sellProduct(int  piece),
който при подаден брой бройки намалява от общия брой с толкова, колкото са продадени и връща true,
а ако  наличноститеса  свършили,  хвърля  изключение NoMoreProductsException. Създайте  класовете Electronics и Book,
наследяващи Product.  Нека Electronics съдържа член-променливите производител (manufacturer) и модел (model),
а Book –информация  за  автор  (author)  и  заглавие  (title).  Промоционалната  цена  за електрониката  е  с  10%  по-ниска,
а  за  книгите  с  50  на  сто.  За  всички  класове реализирайте конструктори с параметри и съответните методи за достъп и методи за промяна.
Реализирайте  собствени  изключения –NoMoreProductsException и WrongPhoneNumberException.
Напишете  интерфейс ValidatePhone,  съдържащ статичен  метод boolean   validatePhoneNumber(String   phoneNumber),
който проверява валидността на въведен телефонен номер на доставчик. Нека при непълен или  грешен  (съдържащ  не  само  цифри)
номер  да  се  хвърля WrongPhoneNumberException.
2. Създайте интерфейсImportData, съдържащметодаObject[] importDataFromFile(), хвърлящIOException.
Създайте клас, имплементиращинтерфейса, симеProductLoader. Тойчетеотфайлнаиме: „salesproducts.txt“.
Файлът съдържа информацията за обекти от тип Product: (info..)
Данните за всеки от обектите се записват на нов ред. Ако даден символен низ започва с 1 –то имате обект от тип Electronics,
в случай че започва с 2 –обект от тип Book. Методът, който ще предефинирате ще връща масив с обекти от тип Product.
За да откриете  с  колко  елемента  да  инициализирате  масива  създайте  метод int getNumberOfRows(), хвърлящ IOException,
който връща броя редове във файла. 3. СъздайтекласBlackFriday, съдържащдвапубличнимасива–оттипElectronics иоттипBook.
Създайте статичен метод void processSales(), в който чрез ProductLoader заредете стоките предвидени за продажба.

*/

/*
import .lab_6.black_friday_event.BlackFriday;
import lab_exercises.lab_6.validation.NoMoreProductsException;

import java.util.Arrays;

    public class Main {
        public static void main(String[] args) {
            BlackFriday.processSales();
            System.out.println(Arrays.toString(BlackFriday.books));
            System.out.println(Arrays.toString(BlackFriday.electronic));
            System.out.println("Book 0 price: " + BlackFriday.books[0].getPromotionalPrice());
            try {
                System.out.println("Book 0 buy: " + BlackFriday.books[0].sellProduct(100));
                System.out.println("Book 0 buy: " + BlackFriday.books[0].sellProduct(100));
                System.out.println("Book 0: " + BlackFriday.books[0]);
                System.out.println("Book 0 buy: " + BlackFriday.books[0].sellProduct(1000));
            } catch (NoMoreProductsException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
*/