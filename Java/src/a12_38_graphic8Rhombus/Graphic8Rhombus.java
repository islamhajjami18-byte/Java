package a12_38_graphic8Rhombus;
import java.util.Scanner;

public class Graphic8Rhombus {
        public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of lines:");
        int lines = sc.nextInt();

        System.out.println("Enter character:");
        char character = sc.next().charAt(0);

        for (int i = 1; i <= lines; i++) {

            for (int j = lines; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j < i; j++) {
                System.out.print(character);
            }

            for(int j = 1; j <= i; j++) {
                System.out.print(character);
            }
            System.out.println();
        }

        for (int i = 1; i < lines; i++) {

            for(int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            for (int j = lines; j > i; j--) {
                System.out.print(character);
            }

            for(int j = lines - 1; j > i; j--) {
                System.out.print(character);
            }
            System.out.println();
        }
        sc.close();
    }
}

