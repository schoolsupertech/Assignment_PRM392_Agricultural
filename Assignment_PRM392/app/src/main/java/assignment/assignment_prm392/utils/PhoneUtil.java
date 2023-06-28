package assignment.assignment_prm392.utils;

import assignment.assignment_prm392.exception.PhoneException;
import java.util.regex.Pattern;

public class PhoneUtil {
    // Check phone number format
    public static boolean phonePattern(String phone) throws PhoneException, Exception {
        String regex = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|" +
                "(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?" +
                "(\\d{3})$";

        return Pattern.compile(regex).matcher(phone).matches();
    }
}
