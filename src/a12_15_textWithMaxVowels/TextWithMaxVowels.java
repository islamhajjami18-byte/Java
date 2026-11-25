package a12_15_textWithMaxVowels;

import java.util.Scanner;

public class TextWithMaxVowels {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String vowels = "AÀÁÄÂEÈÉËÊIÍÌÏÎOÒÓÖÔUÙÚÜÛ";

        String text = "";
        String result = "";

        int max = 0;
        boolean hasText = false;

        System.out.println("Enter text (enter to finish):");
        text = scanner.nextLine();

        
        while (!text.isEmpty()) {

            hasText = true;

            int count = 0;

            for (int i = 0; i < text.length(); i++) {

                char c = Character.toUpperCase(text.charAt(i));

                boolean found = false;

                for (int j = 0; j < vowels.length() && !found; j++) {

                    if (c == vowels.charAt(j)) {
                        count++;
                        found = true;
                    }
                }
            }

            if (count > max) {

                max = count;
                result = text;

            } else if (count == max) {

                result = result + ", " + text;
            }

            System.out.println("Enter text (enter to finish):");
            text = scanner.nextLine();
        }

        // Mostra resultats
        if (!hasText) {

            System.out.println("Text not entered");

        } else {

            System.out.println("Quantity of vowels: " + max);
            System.out.println("Text: " + result);
        }

        scanner.close();
    }
}
