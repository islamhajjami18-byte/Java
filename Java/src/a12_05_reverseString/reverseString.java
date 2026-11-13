/*
* reverseString.java Nov 13, 2026
*
*
* ©Copyright 2026 islam hajjami <islamhajjami18@gmail.com>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package a12_05_reverseString;
import java.util.Scanner;

public class ReverseString {
	public static void main(String args []) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter a text: ");
	        String text = sc.nextLine();

	        if (text.isEmpty()) {
	            System.out.println("Text not entered");
	        } else {
	            String reverse = "";

	            for (int i = text.length() - 1; i >= 0; i--) {
	                reverse += text.charAt(i);
	            }

	            System.out.println(reverse);
	        }

	        sc.close();
	    }
	}
