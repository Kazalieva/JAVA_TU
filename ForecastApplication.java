import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Locale;
import java.util.ResourceBundle;

public class ForecastApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filename = scanner.nextLine();
        String senderEmail = scanner.nextLine();
        String password = scanner.nextLine();
        String receiverEmail = scanner.nextLine();

        String selectedLanguage = scanner.nextLine();
        Locale locale;
        if (selectedLanguage.equalsIgnoreCase("en")) {
            locale = Locale.ENGLISH;
        } else if (selectedLanguage.equalsIgnoreCase("de")) {
            locale = Locale.GERMAN;
        } else {
            System.out.println("Unsupported language.");
            return;
        }

        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);

        String fileExistsMessage = messages.getString("The file exists.");
        String fileDoesNotExistMessage = messages.getString("The file does not exist.");
        File file = new File(filename);

        if (file.exists()) {
            System.out.println(fileExistsMessage);
        } else {
            System.out.println(fileDoesNotExistMessage);
        }


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;

            List<Integer> days = new ArrayList<>();
            List<Integer> temperatures = new ArrayList<>();
            List<Integer> winds = new ArrayList<>();
            List<Integer> humidities = new ArrayList<>();
            List<Integer> precipitations = new ArrayList<>();
            List<String> lightnings = new ArrayList<>();
            List<String> clouds = new ArrayList<>();
            List<Integer> favorableDays = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(" ");
                for (int i = 0; i < values.length; i++) {
                    days.add(Integer.parseInt(values[0]));
                    temperatures.add(Integer.parseInt(values[1]));
                    winds.add(Integer.parseInt(values[2]));
                    humidities.add(Integer.parseInt(values[3]));
                    precipitations.add(Integer.parseInt(values[4]));
                    lightnings.add(values[5]);
                    clouds.add(values[6]);
                }
            }

            for (int i = 0; i < days.size(); i++) {
                int temperature = temperatures.get(i);
                int wind = winds.get(i);
                int humidity = humidities.get(i);
                int precipitation = precipitations.get(i);
                String lightning = lightnings.get(i);
                String cloud = clouds.get(i);

                if ((temperature >= 2 && temperature <= 31) && wind <= 10 && humidity < 60 && precipitation == 0
                        && lightning.equals("No") && !(cloud.equals("Cumulus") || cloud.equals("Nimbus"))) {
                    favorableDays.add(days.get(i));
                }
            }

            if (favorableDays.isEmpty()) {
                System.out.println("No favorable days found for space shuttle launch.");
            } else {
                System.out.println("Favorable days for space shuttle launch: " + favorableDays);
            }


            int maxTemperature = calculateMax(temperatures);
            int minTemperature = calculateMin(temperatures);
            int medianTemperature = calculateMedian(temperatures);
            double avrTemperature = calculateAvr(temperatures);

            int maxWind = calculateMax(winds);
            int minWind = calculateMin(winds);
            int medianWind = calculateMedian(winds);
            double avrWind = calculateAvr(winds);

            int maxHumidity = calculateMax(humidities);
            int minHumidity = calculateMin(humidities);
            int medianHumidity = calculateMedian(humidities);
            double avrHumidity = calculateAvr(humidities);

            int maxPrecipitation = calculateMax(precipitations);
            int minPrecipitation = calculateMin(precipitations);
            int medianPrecipitation = calculateMedian(precipitations);
            double avrPrecipitation = calculateAvr(precipitations);

            try {
                FileWriter writer = new FileWriter("WeatherReport.csv");
                writer.append("Aggregates\n");
                writer.append("Temperature, ").append(Double.toString(avrTemperature)).append(", ").append(Integer.toString(maxTemperature)).append(", ").append(Integer.toString(minTemperature)).append(", ").append(Integer.toString(medianTemperature)).append("\n");
                writer.append("Wind, ").append(Double.toString(avrWind)).append(", ").append(Integer.toString(maxWind)).append(", ").append(Integer.toString(minWind)).append(", ").append(Integer.toString(medianWind)).append("\n");
                writer.append("Humidity, ").append(Double.toString(avrHumidity)).append(", ").append(Integer.toString(maxHumidity)).append(", ").append(Integer.toString(minHumidity)).append(", ").append(Integer.toString(medianHumidity)).append("\n");
                writer.append("Precipitation, ").append(Double.toString(avrPrecipitation)).append(", ").append(Integer.toString(maxPrecipitation)).append(", ").append(Integer.toString(minPrecipitation)).append(", ").append(Integer.toString(medianPrecipitation)).append("\n");

                StringBuilder stringBuilder = new StringBuilder();
                for (Integer day : favorableDays) {
                    stringBuilder.append(day).append(", ");
                }
                writer.append(stringBuilder.toString()).append("\n");

                writer.flush();
                writer.close();
                System.out.println("Weather report is generated!");
            } catch (IOException e) {
                System.out.println("An error occurred while generating the weather report.");
                e.printStackTrace();
            }

            bufferedReader.close();

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.outlook.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject("Weather Report");


            Multipart multipart = new MimeMultipart();


            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Please find attached the weather report.");


            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File("WeatherReport.csv"));


            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);


            message.setContent(multipart);


            Transport.send(message);

            System.out.println("Weather report sent successfully.");


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }
    }


    public static int calculateMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int value : list) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int calculateMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int value : list) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static int calculateMedian(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list);
        sortedList.sort(null);
        int size = sortedList.size();
        if (size % 2 == 0) {
            int mid = size / 2;
            return (sortedList.get(mid - 1) + sortedList.get(mid)) / 2;
        } else {
            return sortedList.get(size/2);
        }
    }

    public static double calculateAvr(List<Integer> list) {
        double sum = 0;
        for (int value : list) {
            sum += value;
        }
        return sum / list.size();
    }
}
