/*
* LongestText.java Nov 13, 2026
*
*
* ©Copyright 2026 islam hajjami <islamhajjami18@gmail.com>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package a12_09_longestText;
import java.util.Scanner;

public class LongestText {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a text (END to finish):");
		String txt = sc.nextLine();
		
		if (txt.isEmpty() || txt.equalsIgnoreCase("end")) {
			System.out.println("Text not entered");
		} else {
		int len = 0;
		String res = "";
		int max = 0;
		
		while (!txt.equalsIgnoreCase("end")) {
			len = txt.length();	
				if (len > max) {
					max = txt.length();
					res = txt;
				}
			
			System.out.println("Enter a text (END to finish):");
			txt = sc.nextLine();
			
		}
		
		System.out.println("Longest text length: " + max);
		System.out.println("Text: " + res);
		
		}
		
		sc.close();
	}
}
