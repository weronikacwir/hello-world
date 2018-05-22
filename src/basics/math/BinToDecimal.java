package basics.math;


import java.util.Scanner;

public class BinToDecimal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a binary number: ");
		String numInBin = input.nextLine();
		
		try {
			System.out.printf
				("That's %d in decimal.", 
						binToDec(numInBin));
		}
		catch (BinaryFormatException bfe) {
			System.out.println(bfe);
		}
		
		input.close();		

	}

	public static int binToDec(String bin) 
			throws BinaryFormatException {
		int decimalValue = 0;
		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) == '0') {
				decimalValue *= 2;
			}
			else if(bin.charAt(i) == '1') {
				decimalValue *= 2;
				decimalValue++;
			}
			else {
				throw new BinaryFormatException
					(bin.charAt(i) + " is not a bit.");
			}
		}
		
		return decimalValue;	
	}
	
}

class BinaryFormatException extends NumberFormatException {
	private static final long serialVersionUID = 1L;

	BinaryFormatException(String message) {
		super(message);
	}
}
