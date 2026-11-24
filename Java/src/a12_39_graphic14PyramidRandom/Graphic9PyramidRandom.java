package a12_39_graphic14PyramidRandom;
import java.util.Scanner;


public class Graphic9PyramidRandom {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of lines:");
        int lines = sc.nextInt();

        <<<<char star = '\u2606';
        String characters = "+~ox*O";


        for (int i = 1; i <= lines; i++) {
          
            for (int j = lines; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j < i; j++) {
                int rand =(int) (Math.random() * characters.length());
                char c = characters.charAt(rand);
                System.out.print(c);
            }

            for(int j = 1; j <= i; j++) {
                int rand =(int) (Math.random() * characters.length());
                char c = characters.charAt(rand);
                System.out.print(c);
            }
            System.out.println();
        }

        

        sc.close();
    }
}


