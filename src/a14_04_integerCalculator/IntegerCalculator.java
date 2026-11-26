package a14_04_integerCalculator;
import java.util.Scanner;

public class IntegerCalculator {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        System.out.println("Enter the first number:");
        int x = sc.nextInt();

        System.out.println("Enter the second number:");
        int y = sc.nextInt();

        System.out.println("Add = " + add(x, y));
        System.out.println("Subtract = " + subtract(x, y));
        System.out.println("Multiply = " + multiply(x, y));
        System.out.println("Divide = " + divide(x, y));
        System.out.println("Module = " + modulo(x, y));
        System.out.println("Power = " + power(x, y));
        System.out.println("Minimum = " + minimum(x, y));
        System.out.println("Maximum = " + maximum(x, y));
    
    }

    public static int add(int x, int y){
        return x + y;
    }

    public static int subtract(int x, int y){
        return x - y;
    }

    public static int multiply(int x, int y){
        return x * y;
    }

    public static int divide(int x, int y) {
        return x / y;
    }

    public static int modulo(int x, int y) {
        return x % 2;
    }

   public static double power(int x, int y){
        return Math.pow(x, y);
   }

   public static int minimum(int x, int y){
        return Math.min(x, y);
   }

   public static int maximum(int x, int y){
        return Math.max(x, y);
   }

}
