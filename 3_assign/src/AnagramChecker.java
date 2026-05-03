import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first string:");
        String firstWord = input.nextLine();
        System.out.println("Enter second string:");
        String secondWord = input.nextLine();

        if (checkIfAnagrams(firstWord, secondWord)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean checkIfAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] firstChars = s1.toCharArray();
        char[] secondChars = s2.toCharArray();

        sortCharArray(firstChars);
        sortCharArray(secondChars);

        for (int i = 0; i < firstChars.length; i++) {
            if (firstChars[i] != secondChars[i]) return false;
        }
        return true;
    }

    public static void sortCharArray(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}