package a12_20_uniqueVowels;

import java.util.Scanner;

public class UniqueVowels {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String vowels = "AEIOUÀÈÒÙÁÉÍÓÚÄËÏÖÜÂÊÎÔÛ";

        String vowelsFound = "";

        for (int i = 0; i < text.length(); i++) {

            boolean found = false;

            // Cerca per vowels per trobar si conté la vocal
            for (int j = 0; j < vowels.length(); j++) {

                if (Character.toUpperCase(text.charAt(i)) == vowels.charAt(j)) {
                    found = true;
                    break;
                }
            }

            if (found) {

                boolean exists = false;

                for (int k = 0; k < vowelsFound.length(); k++) {

                    if (Character.toUpperCase(text.charAt(i)) == vowelsFound.charAt(k)) {
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    vowelsFound += Character.toUpperCase(text.charAt(i));
                }
            }
        }

        // Mostrar resultats
        System.out.println(vowelsFound);

        scanner.close();
    }
}