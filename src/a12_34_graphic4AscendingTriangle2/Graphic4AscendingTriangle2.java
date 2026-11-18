package a12_34_graphic4AscendingTriangle2;

import java.util.Scanner;

public class Graphic4AscendingTriangle2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of lines:");
        int lines = sc.nextInt();

        System.out.println("Enter character:");
        char character = sc.next().charAt(0);

        for (int i = 1; i <= lines; i++) {

            for (int j = 1; j <= lines - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(character);
            }

            System.out.println();
        }

        sc.close();
    }
}
