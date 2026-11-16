
package a12_18_forbiddenLetters2;

import java.util.Scanner;

public class ForbiddenLetters2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a text:");
        String text = scanner.nextLine();

        String letters = "çñwzqx";
        String frLetters = "";
        boolean found;

     for (int i = 0; i < text.length(); i++) {

            char c = Character.toLowerCase(text.charAt(i));
            found = false;

            
            for (int j = 0; j < letters.length(); j++) {

                if (c == letters.charAt(j)) {

                    frLetters += text.charAt(i);
                    found = true;
                    break;
                }
            }
        }
        if (frLetters.length() > 0) {
            System.out.println("Text contains special letters");
            System.out.println("Forbidden letters: " + frLetters);

        } else {
            System.out.println("Text does not contain special letters");
        }

        scanner.close();
    }
}
