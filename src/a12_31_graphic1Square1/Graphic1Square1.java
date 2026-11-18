package a12_31_graphic1Square1;
import java.util.Scanner;

public class Graphic1Square1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of lines:");
        int lines = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter character:");
        char c = sc.nextLine().charAt(0);

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++) {
                System.out.print(c);
            }
            System.err.println();
        }
        sc.close();     
    }
}