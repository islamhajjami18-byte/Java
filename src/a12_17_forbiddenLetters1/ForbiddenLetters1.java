package a12_17_forbiddenLetters1;

import java.util.Scanner;

public class ForbiddenLetters1 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter a text:");
String text = scanner.nextLine();

String letters = "çñwzqx";
int count = 0;


    for (int i = 0; i < text.length(); i++) {
        char c = Character.toLowerCase(text.charAt(i));

        for (int j = 0; j < letters.length(); j++) {
            if (c == letters.charAt(j)) {
            count++;
            break;
        }

    }

        if (count > 0) {
        break;
        }
    }

        if (count > 0) {
        System.out.println("Text contains special letters");
        } else {
        System.out.println("Text does not contain special letters");
        }

        scanner.close();
    }
}