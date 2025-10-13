import java.util.ArrayList;
import java.util.Stack;

public class ValidPalindrome {

    public static void main(String[] args) {

        Boolean result = ValidPalindrome.isPalindrome("Was it a car osr a cat I saw");
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        int index = 0;
        s = s.toLowerCase().trim();

        int j = s.length() - 1;
        for (int i = 0; i < j; i++) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (s.charAt(i) == s.charAt(j)) {
                j--;
                continue;
            }else {
                return false;
            }

        }
        return true;
    }
}
