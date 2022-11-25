/**
 * 
 */
package main.testdata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Dipti
 *
 */
public class TestDataCreator {


	public static void main(String[] args) {

		try {
			//file created and saved in src folder
			File myFile = new File("src/Test File Finance.txt");
			boolean created = myFile.createNewFile();
			if (created) {
				System.out.println("File has been created successfully!!");
			}
			else {
				System.out.println("File already present!!");
			}
			//object of file writer is created
			FileWriter writer = new FileWriter(myFile);

			//loop for creating 11 pages
			for (int page = 1; page <= 11; page++) {
				//first header line
				for(int i = 1; i <= 80; i++) {
					writer.write("=");
				}
				writer.write("\r");
				//second header line
				writer.write(alignRight("Sample Company", 80));
				writer.write("\r");
				int randomLineNumber = randomNumber(1, 50);
				int randomLineNumber1 = randomNumber(1, 50);
				int randomLineNumber2 = randomNumber(1, 50);
				int randomLineNumber3 = randomNumber(1, 50);
				//logic to append "Finance", "finance", "finance", "testing" strings  
				//String[] fixTexts = {"Finance", "finance", "finance", "testing"};
				List<String> fixTexts = new ArrayList<>();
				fixTexts.add("Finance");
				fixTexts.add("finance");
				fixTexts.add("finance");
				fixTexts.add("testing");
				for(int i = 1; i <= 50; i++) {
					String rand = generateRandom();
					//System.out.println(rand.length());
					if (i == randomLineNumber && rand.length() < 114)
						rand = rand.concat("Finance");
					if (i == randomLineNumber1 && rand.length() < 114)
						rand = rand.concat("finance");
					if (i == randomLineNumber2 && rand.length() < 114)
						rand = rand.concat("finance");
					if (i == randomLineNumber3 && rand.length() < 114)
						rand = rand.concat("testing");
					//System.out.println(fixTexts.length);
					/*for(int m = 0; m < fixTexts.size(); m++) {
						
						if (i == randomNumber(1, 50) && rand.length() < (120 - fixTexts.get(m).length())) {
							System.out.println(i + " " + m);
							rand = rand.concat(fixTexts.get(m));
						}
					}*/
					//lines are separated by carriage return
					writer.write(rand + "\r");
				}
				// first footer line
				for(int i = 1; i <= 65; i++) {
					writer.write("-");
				}
				writer.write("\r");
				//second footer line center aligned
				writer.write(alignCenter("page Number", 65));
				writer.write("\r");
				//third footer line left aligned
				writer.write(alignLeft("S a m p l e    C o m p a n y", 65));
				writer.write("\r");
				writer.write("\n");
			}
			//last line of text if <EOF>
			writer.write("<EOF>");
			writer.flush();
			writer.close();
		} 
		catch(IOException e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		}
	}
	
	// Function to align text at left
	public static String alignLeft(String string, int maxmaxLength) {
	     return String.format("%-" + maxmaxLength + "s", string);  
	}

	// Function to align text at right
	public static String alignRight(String string, int maxmaxLength) {
	    return String.format("%" + maxmaxLength + "s", string);  
	}
	
	// Function to align text at center
	public static String alignCenter(String s, int maxLength) {
	    if (s.length() > maxLength) {
	        return s.substring(0, maxLength);
	    } else if (s.length() == maxLength) {
	        return s;
	    } else {
	        int leftPadding = (maxLength - s.length()) / 2; 
	        StringBuilder leftBuilder = new StringBuilder();
	        for (int i = 0; i < leftPadding; i++) {
	            leftBuilder.append(" ");
	        }

	        int rightPadding = maxLength - s.length() - leftPadding;
	        StringBuilder rightBuilder = new StringBuilder();
	        for (int i = 0; i < rightPadding; i++) 
	            rightBuilder.append(" ");

	        return leftBuilder.toString() + s 
	                + rightBuilder.toString();
	    }
	}

	// Function to generate random number
	public static int randomNumber(int low, int high){
		return ((int)(Math.random()*(high-low)) + low);
	}

	// Function to generate random currency number in same format $999,999,999,999.99
	public static String getRandomCurrencyNumber(){
		StringBuilder currency = new StringBuilder();
		int currencyRange = randomNumber(2, 4);
		String numbers = "123456789";

		for (int i = 0; i < currencyRange; i++) {
			currency.append(numbers.charAt((int)(numbers.length() * Math.random())));
		}
		currency.append(".");
		currency.append(numbers.charAt((int)(numbers.length() * Math.random())));
		currency.append(numbers.charAt((int)(numbers.length() * Math.random())));

		Locale usa = new Locale("en", "US");
		java.text.NumberFormat dollerFormat = NumberFormat.getCurrencyInstance(usa);
		return dollerFormat.format(Double.parseDouble(currency.toString()));
	}

	// Function to generate random string along with total line in text
	private static String generateRandom() {
		String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvxyz";

		String specialChars = ", .\t";

		StringBuilder res = new StringBuilder();

		int lineRange = randomNumber(60, 113);
		int wordRange = randomNumber(1, 10);

		for (int j = 0; j < lineRange; j++) {
			wordRange = randomNumber(1, 10);
			j = j + wordRange;
			if (j > lineRange) {
				break;
			}
			for (int i = 0; i < wordRange; i++) {
				int index = (int)(aToZ.length() * Math.random());
				res.append(aToZ.charAt(index));
			}
			
			j = j + 1;
			if (j > lineRange) {
				break;
			}
			res.append(specialChars.charAt((int)(specialChars.length() * Math.random())));
			
			j = j + getRandomCurrencyNumber().length();
			if (j > lineRange) {
				break;
			}
			res.append(getRandomCurrencyNumber());
			
			j = j + 1;
			if (j > lineRange) {
				break;
			}
			res.append(specialChars.charAt((int)(specialChars.length() * Math.random())));
		}

		return res.toString();
	}


}
