package a12_33_graphic3AscendingTriangle1;
import java.util.Scanner;

public class Graphic3AscendingTriangle1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of lines:");
        int lines = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter character:");
        char c = sc.nextLine().charAt(0);

        String str = "";
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j <= i; j++) {
                
                str += c;
            }
            str += "\n";
        }

        System.out.print(str);
        sc.close();     
    }
}