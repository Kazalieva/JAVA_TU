package lab_6;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public interface ValidatePhone {
    static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException{
      Pattern pattern = Pattern.compile("\\d{10}");
      Matcher matcher = pattern.matcher(phoneNumber);
      if(matcher.matches()){
          return true;
      }
      else throw new WrongPhoneNumberException();
    }

}
