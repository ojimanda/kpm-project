package id.yozi.kpmservice.Utils;

import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUtil {

    public Boolean regexEmail(String email) {

        boolean result = false;
        String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()) {
            result = true;
        }
        return result;
    }

    public Boolean regexPassword(String password) {

        boolean result = false;
        // 9 digit, lowercase, uppercase, spc char, 8-20 char
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()) {
            result = true;
        }
        return result;
    }

    public BigInteger setExpired10Day() {
        return BigDecimal.valueOf(1000 * 60 * 24 * 10).toBigInteger();
    }
}
