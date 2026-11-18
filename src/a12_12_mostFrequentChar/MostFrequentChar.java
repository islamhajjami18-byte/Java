package a12_12_mostFrequentChar;

import java.util.Scanner;

public class MostFrequentChar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");

        String text = sc.nextLine();

        char mostFr = 'a';
        int lettercount = 0;
        int max = 0;

        for (int i = 0; i < text.length(); i++) {

            lettercount = 0;

            char c = text.charAt(i);

            for (int j = 0; j < text.length(); j++) {

                char c2 = text.charAt(j);

                if (Character.toLowerCase(c) == Character.toLowerCase(c2)) {

                    lettercount++;
                }
            }

            if (lettercount > max) {

                max = lettercount;
                mostFr = c;
            }
        }

        if (max == 1) {
        System.out.println("Most freqüent character: '" + mostFr + "' appears " + max + " time");
        } else {
        	System.out.println("Most freqüent character: '" + mostFr + "' appears " + max + " times");
        }
        sc.close();
    }
}
