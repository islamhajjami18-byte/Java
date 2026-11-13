/*
* RemoveRepeatedLetters.java Nov 13, 2026
*
*
* ©Copyright 2026 islam hajjami <islamhajjami18@gmail.com>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package a12_07_removeRepeatedLetters;
import java.util.Scanner;


public class RemoveRepeatedLetters {
	public static void main(String args []) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter a text:");
		String txt = sc.nextLine();
		
		String res = "";
		
		if (txt.isEmpty()) {
			
			System.out.println("Text not entered");
		
		} else {
		
			for (int i = 0; i < txt.length(); i++) {
				char c = txt.charAt(i);
			
				if ( i == 0) {
					res += c;
				} else if ( c != txt.charAt(i - 1)) {
					
					res += c;
				}
			
			}
			
			System.out.println("Clean text: " + res);
		}
		
		
		sc.close();
  
	
	}
}