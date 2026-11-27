
package a11_04_guessPassword;

import java.util.Scanner;

public class GuessPassword {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        String adminPass = "houdayfa";
        String rootPass = "kL?Je45op";
        int count = 0;

        System.out.println("Login as: ");
        String user = sc.nextLine();

        if (!user.equals("admin") && !user.equals("root")) {
            System.out.println("This user does not exist!");
        } else {

            while (true) {

                System.out.println(user + "@211.174.173.184's password: ");
                String userPass = sc.nextLine();

                count++;

                if ((user.equals("admin") && userPass.equals(adminPass))|| (user.equals("root") && userPass.equals(rootPass))) {
                    break;
                }
            }

            System.out.println("Welcome to Ubuntu 24.04.3 LTS. You have used "
                    + count + " attempts.");
        }

        sc.close();
    }
}
