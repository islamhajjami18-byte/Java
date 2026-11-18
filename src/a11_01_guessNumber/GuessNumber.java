package a11_01_guessNumber;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String args []) {

        Scanner sc = new Scanner (System.in);

        int correctNum = 7;
        boolean correct = false;

        System.out.println("Enter number of attempts (grater than 1):");
        int attempts = sc.nextInt();

        while (attempts <= 1) {
            System.out.println("Enter number of attempts (grater than 1):");
            attempts = sc.nextInt();
        }

        System.out.println("Attempt " + 1 + ": Enter your guess (1..10):");
        int userAttempts = sc.nextInt();

        for (int i = 1; i < attempts; i++) {
 
            while (userAttempts < 1 || userAttempts > 10) {
                System.out.println("Attempt " + i + ": Enter your guess (1..10):");
                userAttempts = sc.nextInt();
            }
            
            if (userAttempts < correctNum) {
                System.out.println("Too low. Attempt " + (i + 1) + ": Enter your guess (1..10):");
                userAttempts = sc.nextInt();
            } else if (userAttempts > correctNum) {
                System.out.println("Too high. Attempt " + (i + 1) + ": Enter your guess (1..10):");
                userAttempts = sc.nextInt();
            } else {
                break;
            }
        
        }
            if (userAttempts < correctNum) {
                System.out.println("Too low. You lost! The secret number was 7.");
            } else if (userAttempts > correctNum) {
                System.out.println("Too high. You lost! The secret number was 7.");
            } else {
                System.out.println("Correct! You guessed the number.");
            }

        sc.close();
    }    
}
