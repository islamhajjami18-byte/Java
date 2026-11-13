package a12_11_countVowels;
import java.util.Scanner;

public class CountVowels {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		String vowels = "AÀÁÄÂEÈÉËÊIÍÌÏÎOÒÓÖÔUÙÚÜÛ";
		System.out.println("Enter text: ");
		String text = sc.nextLine();

		int count = 0;;
		// Recórrer les vocals
		if (!text.isEmpty()) {
		for (int i = 0; i < vowels.length(); i++) {
		
			char v = vowels.charAt(i);

			// Recórrer el text
			for (int j = 0; j < text.length(); j++) {
				// Comprova si el caràcter actual coincideix amb la vocal			
				char c = text.charAt(j);
				if (Character.toUpperCase(c) == v ) {
					count++;
			   }

		    }
		}
		System.out.println("Quantity of vowels: "+ count);
		sc.close();
		}
		else {
			System.out.println("Text not entered");
		}
		
	}
}