
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        System.out.println(validatePin("125856"));
    }

    public static boolean validatePin(String pin) {
        return pin.matches("\\d{4}|\\d{6}");
    }
}
