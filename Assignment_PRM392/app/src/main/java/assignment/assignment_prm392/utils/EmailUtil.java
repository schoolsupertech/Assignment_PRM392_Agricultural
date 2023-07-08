package assignment.assignment_prm392.utils;

import assignment.assignment_prm392.exception.EmailException;

import java.util.regex.Pattern;

public class EmailUtil {
    // Check email format
    public static boolean emailPattern(String email) throws Exception {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" +
                "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        return Pattern.compile(regexPattern).matcher(email).matches();
    }
}
