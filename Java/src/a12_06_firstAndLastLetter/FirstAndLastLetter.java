/*
* FirstAndLastLetter.java Nov 13, 2026
*
*
* ©Copyright 2026 islam hajjami <islamhajjami18@gmail.com>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package a12_06_firstAndLastLetter;
import java.util.Scanner;

public class FirstAndLastLetter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word;
        String result = "";
        int total = 0;

        System.out.println("Enter word: ");
        word = sc.nextLine();

        while (!word.equalsIgnoreCase("end")) {

            if (word.length() >= 2) {

                char first = word.charAt(0);
                char last = word.charAt(word.length() - 1);

                if (Character.isLetter(first) && Character.isLetter(last) && Character.toLowerCase(first) == Character.toLowerCase(last)) {

                    result += word + "\n";
                    total++;
                }
            }

            System.out.println("Enter word: ");
            word = sc.nextLine();
        }

        if (total == 0) {
            System.out.println("No words entered");
        } else {
            System.out.println("Total words: " + total);
            System.out.println(result);
        }

        sc.close();
    }
}
