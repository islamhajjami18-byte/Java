package a14_08_tax2;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner (System.in);

    public static void main(String args[]) {

        System.out.println("1. Calculate tax from price");
        System.out.println("2. Calculate price with tax");
        System.out.println("3. Get tax from a price");
        System.out.println("Option");

        int option =  sc.nextInt();

        System.out.println("Enter the price:");
        float price = sc.nextFloat();
    
        if (option == 1) {

            System.out.printf("Tax for %.2f is %.2f%n", price, Tax.tax(price));

        } else if (option == 2) {

            System.out.printf("Price with tax: %.2f%n", Tax.priceWithTax(price));

        } else if (option == 3) {

            System.out.printf("Tax included in %.2f is %.2f%n", price, Tax.getTaxFromPrice(price));

        }
        sc.close();
    }
}
