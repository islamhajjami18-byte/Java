package a14_01_numberCheck1;

public class NumberCheck1{

    public static int number = 0;

    public static void main(String[] args) {
        printTitle();
        printNumber();
        checkEvenOdd();
        checkSign();
        checkDigits();
        checkPrime();
        printEndMessage();
    }

    public static void printTitle() {
        System.out.println("NUMBER ANALYSIS PROGRAM");
    }

    public static void printNumber() {
        System.out.println("Number: " + number);

    }

    public static void checkEvenOdd() {
        if (number % 2 == 0) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");

        }
    }

    public static void checkSign() {
        if (number > 0) {
            System.out.println("The number is positive");
        } else if (number < 0) {
            System.out.println("The number is negative");
        } else {
            System.out.println("The number is zero");
        }
    }

    public static void checkDigits() {
        
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

    public static void checkPrime() {
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

    public static void printEndMessage() {
        System.out.println("END OF PROGRAM");
    }

}