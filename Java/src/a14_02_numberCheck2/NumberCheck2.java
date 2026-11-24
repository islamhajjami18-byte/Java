package a14_02_numberCheck2;

import java.util.Scanner;

public class NumberCheck2{

    public static int number = -123;

    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int number = scanner.nextInt();

        printMessage("NUMBER ANALYSIS PROGRAM");
        printNumber(number);
        checkEvenOdd(number);
        checkSign(number);
        checkDigits(number);
        checkPrime(number);
        printMessage("END OF PROGRAM");

        scanner.close();
    }

    public static void printMessage(String firstMessage) {
        System.out.println(firstMessage);
    }

    public static void printNumber(int number) {
        System.out.println("Number: " + number);

    }

    public static void checkEvenOdd(int number) {
        if (number % 2 == 0) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");

        }
    }

    public static void checkSign(int number) {
        if (number > 0) {
            System.out.println("The number is positive");
        } else if (number < 0) {
            System.out.println("The number is negative");
        } else {
            System.out.println("The number is zero");
        }
    }

    public static void checkDigits(int number) {
        
    int num = Math.abs(number);
    int count = 0;

        if (num == 0) {
            count = 1;
        } else {
            while (num > 0) {
                num = num / 10;
                count++;
            }
    }
    
        if (count == 1) {
            System.out.println("The number has " + count + " digit");
        } else {
            System.out.println("The number has " + count + " digits");
        }
    }

    public static void checkPrime(int number) {
    boolean prime = number >= 2;

    for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
            prime = false;
            break;
        }
    }

    if (prime) {
        System.out.println("The number is a Prime number");
    } else {
        System.out.println("The number is not a Prime number");
    }
    }

    public static void printEndMessage(String secondMessage) {
        System.out.println(secondMessage);
    }

}