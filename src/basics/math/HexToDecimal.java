package basics.math;



import java.util.Scanner;


/**
 * Tests the modified implementation of hexToDec(String hex)
 * and hexCharToDecimal(char ch).
 *
 */
public class HexToDecimal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a hex number: ");
		String numInHex = input.nextLine();
		
		try {
			System.out.printf
				("That's %d in decimal.", 
						hexToDec(numInHex.toUpperCase()));
		}
		catch (NumberFormatException nfe) {
			System.out.println(nfe);
		}
		
		input.close();
	}

	public static int hexToDec(String hex) 
			throws NumberFormatException {
		int decimalValue = 0;
		for (int i = 0; i < hex.length(); i++) {
			char hexChar = hex.charAt(i);
			decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
		}
		
		return decimalValue;	
	}
	
	public static int hexCharToDecimal(char ch) 
			throws NumberFormatException {
		if ('A' <= ch && ch <= 'F') 
			return 10 + ch - 'A';
		else if ('0' <= ch && ch <= '9')
			return ch - '0';
		else
			throw new NumberFormatException 
				(ch + " is not a nibble.");
	}
}
