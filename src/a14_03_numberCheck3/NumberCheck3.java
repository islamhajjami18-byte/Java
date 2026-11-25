package a14_03_numberCheck3;
import java.util.Scanner;

public class NumberCheck3 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        int number = askNumber("Enter number:");
        
        printMessage("NUMBER ANALYSIS PROGRAM");
        printNumber(number);
        System.out.println("The number is :" + checkEvenOdd(number));
        System.out.println("the number is :" + checkSign(number));
        int digits = checkDigits(number);
        if (digits == 1) {
            System.out.println("The number has " + digits + " digit");
        } else {
            System.out.println("The number has " + digits + " digits");
        }
        boolean prime = checkPrime(number);
        if (prime) {
        System.out.println("The number is a Prime number");
        } else {
            System.out.println("The number is not a Prime number");
        }
        printMessage("END OF PROGRAM");


    }

    public static void printMessage(String text) {
        System.out.println(text);
    }

    public static int askNumber(String text) {
        System.out.println(text);
        return sc.nextInt();
    }

    public static void printNumber(int number) {
        System.out.println("Number:" + number);
    }

    public static String checkEvenOdd(int number) {
        if (number % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    public static String checkSign(int number) {
       if (number > 0) {
            return "positive";
        } else if (number < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }

    public static int checkDigits(int number) {
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
        return count;
    }

    public static boolean checkPrime(int number) {
        boolean prime = number>=2;

    for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
            prime = false;
            break;
        }
    }
        return prime;
    }

}