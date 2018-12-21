import java.util.Scanner;

public class HackerEarthSecond {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


            String str = scanner.next();

           solution(str);
        }


    private static void solution(final String string) {
        final char[] chars = string.toCharArray();
        int numberOfAlphabets = 0;
        int numberOfDigits = 0;
        for (int i = 0; i < chars.length; i++) {
            if(Character.isAlphabetic(chars[i])) {
                numberOfAlphabets++;
            } else if(Character.isDigit(chars[i])) {
                numberOfDigits++;
            }
        }
        System.out.println(numberOfDigits);
        System.out.println(numberOfAlphabets);

    }
}
