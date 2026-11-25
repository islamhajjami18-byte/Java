
package a12_19_forbiddenLetters3;

import java.util.Scanner;

public class ForbiddenLetters3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a text:");
        String text = sc.nextLine();

        String letters = "çñwzqx";
        String results = "";

        for (int i = 0; i < text.length(); i++) {

            char c = Character.toLowerCase(text.charAt(i));
            boolean forbidden = false;

            for (int j = 0; j < letters.length(); j++) {

                if (c == letters.charAt(j)) {
                    forbidden = true;
                    break;
                }
            }

            if (forbidden) {

                boolean exists = false;

                for (int k = 0; k < results.length(); k++) {

                    if (c == results.charAt(k)) {
                        exists = true;
                        break;
                    }
                }

                // Afegir només si no existeix
                if (!exists) {
                    results += c;
                }
            }
        }

        if (results.length() > 0) {
            System.out.println("Text contains special letters");
            System.out.println("Forbidden letters: " + results);

        } else {
            System.out.println("Text does not contain special letters");
        }

        sc.close();
    }
}
