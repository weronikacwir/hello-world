package recursion;
/**
 * Naive implementation of solutions to Lab 03 - Recursion for CS 2013.
 * 
 * See OptimizedRecursion for more efficient solutions. 
 * 
 * @author Weronika Cwir
 *
 */

public class Recursion {

	public static void main(String[] args) {

		/////////////////////// TESTS FOR Q1 ///////////////////////////////////
		System.out.println("---------- Q1 X^N ------------------------------");
		System.out.println("powerN(2, 0) is " + powerN(2,0));
		System.out.println("powerN(2, 1) is " + powerN(2,1));
		System.out.println("powerN(2, 5) is " + powerN(2,5));
		System.out.println();

		/////////////////////// TESTS FOR Q2  //////////////////////////////////
		System.out.println("---------- Q2 HARMONIC SERIES ------------------");
		System.out.println("harmonicSum(1) is " + harmonicSum(1));
		System.out.println("harmonicSum(2) is " + harmonicSum(2));
		System.out.println("harmonicSum(5) is " + harmonicSum(5));
		System.out.println();

		/////////////////////// TESTS FOR Q3  //////////////////////////////////
		System.out.println("---------- Q3 REVERSE INT ----------------------");
		System.out.print("reverseDisplay(1) is "); reverseDisplay(1);
		System.out.print("\nreverseDisplay(12) is "); reverseDisplay(12);
		System.out.print("\nreverseDisplay(123) is "); reverseDisplay(123);
		System.out.println("\n");
		
		/////////////////////// TESTS FOR Q4  //////////////////////////////////
		System.out.println("---------- Q4 REVERSE STRING -------------------");
		System.out.print("reverseDisplay(null) is "); reverseDisplay(null);
		System.out.print("\nreverseDisplay(\"\") is "); reverseDisplay("");
		System.out.print("\nreverseDisplay(\"a\") is "); reverseDisplay("a");
		System.out.print("\nreverseDisplay(\"ab\") is "); reverseDisplay("ab");
		System.out.print("\nreverseDisplay(\"abc\") is "); reverseDisplay("abc");
		System.out.println("\n");
		
		/////////////////////// TESTS FOR Q5  //////////////////////////////////
		System.out.println("---------- Q5 STRING CONTAINS CHAR -------------");
		System.out.println("recursiveContains('a', null) is "
						  + recursiveContains('a', null));
		System.out.println("recursiveContains('a',\"\") is "
		                  + recursiveContains('a', ""));
		System.out.println("recursiveContains('a', \"a\") is "
						  + recursiveContains('a', "a"));
		System.out.println("recursiveContains('a', \"b\") is "
				          + recursiveContains('a', "b"));
		System.out.println("recursiveContains('a', \"ab\") is "
						  + recursiveContains('a', "ab"));
		System.out.println("recursiveContains('a', \"ba\") is "
				          + recursiveContains('a', "ba"));	
		System.out.println("recursiveContains('a', \"bcabx\") is "
				          + recursiveContains('a', "bcabx"));
		System.out.println("recursiveContains('x', \"bcbz\") is "
				          + recursiveContains('x', "bcbz"));
		System.out.println();

		/////////////////////// TESTS FOR Q6  //////////////////////////////////
		System.out.println("---------- Q6 ALL CHARS SAME -------------------");
		System.out.println("recursiveAllCharactersSame(null) is "
						  + recursiveAllCharactersSame(null));
		System.out.println("recursiveAllCharactersSame(\"\") is "
		                  + recursiveAllCharactersSame(""));
		System.out.println("recursiveAllCharactersSame(\"a\") is "
						  + recursiveAllCharactersSame("a"));
		System.out.println("recursiveAllCharactersSame(\"ab\") is "
				          + recursiveAllCharactersSame("ab"));
		System.out.println("recursiveAllCharactersSame(\"bb\") is "
				          + recursiveAllCharactersSame("bb"));	
		System.out.println("recursiveAllCharactersSame(\"xxyy\") is "
				  		  + recursiveAllCharactersSame("xxyy"));
		System.out.println("recursiveAllCharactersSame(\"zzzzz\") is "
				          + recursiveAllCharactersSame("zzzzz"));
		System.out.println();
		
		/////////////////////// TESTS FOR Q7  //////////////////////////////////
		System.out.println("---------- Q7 CHAR COUNT  ----------------------");
		System.out.println("recursiveCount('a', null) is "
						  + recursiveCount('a', null));
		System.out.println("recursiveCount('a',\"\") is "
		                  + recursiveCount('a', ""));
		System.out.println("recursiveCount('a', \"a\") is "
						  + recursiveCount('a', "a"));
		System.out.println("recursiveCount('a', \"b\") is "
				          + recursiveCount('a', "b"));
		System.out.println("recursiveCount('a', \"ab\") is "
						  + recursiveCount('a', "ab"));
		System.out.println("recursiveCount('a', \"ba\") is "
				          + recursiveCount('a', "ba"));	
		System.out.println("recursiveCount('a', \"bcabx\") is "
				          + recursiveCount('a', "bcabx"));
		System.out.println("recursiveCount('x', \"bcbz\") is "
				          + recursiveCount('x', "bcbz"));
		System.out.println("recursiveCount('x', \"xyxyyyyxx\") is "
		                  + recursiveCount('x', "xyxyyyyxx"));
		System.out.println();

	}

	/**
	 * Q1: recursive method that computes x^n for a positive integer n
	 */
	public static double powerN (double x, int n) {
		if (n < 0)
			return 0; // Illegal argument case
		else if (n == 0)
			return 1;
		else
			return  x * powerN(x, n - 1);
	}

	/**
	 *  Q2: recursive method that computes the following series
	 *      S = 1 + 1/2 + 1/3 + ...+1/ n
	 */
	public static double harmonicSum(int n) {
		if (n < 1) {
			return 0; // Illegal argument case
		}
		else if (n == 1) {
			return 1;
		}
		else {
			return 1.0/n + harmonicSum(n - 1);
		}
	}


	/**
	 *  Q3: recursive method that displays an int value reversely 
	 *      on the console
	 */
	public static void reverseDisplay(int value){
		if ((value % 10) == value) { 
			System.out.print(value);
		}
		else {
			System.out.print(value % 10);
			reverseDisplay(value/10);
		}
	}

	/**
	 * Q4: recursive method that displays a string reversely on the console
	 */
	public static void reverseDisplay(String value){
		if (value == null || value.length() == 0)
			return;
		else if (value.length() == 1) {
			System.out.print(value);
		}
		else {
			System.out.print(value.charAt(value.length() - 1));
			reverseDisplay(value.substring(0, value.length() - 1));
		}
	}

	/**
	 * Q5: recursive method that returns true if the String contains the char, 
	 *     otherwise returns false
	 */
	public static boolean recursiveContains(char c, String s){
		if (s == null || s.length() == 0) {
			return false;
		}
		else if (s.length() == 1) {
			return (s.charAt(0) == c);
		}
		else {
			if (s.charAt(0) == c)
				return true;
			else
				return recursiveContains(c, s.substring(1));
		}
	}

	/**
	 * Q6: recursive method that returns true if all the characters in the 
	 *     String are identical, otherwise false. If the String is empty, 
	 *     all the characters are identical.
	 */
	public static boolean recursiveAllCharactersSame(String s){
		if (s == null || s.length() <= 1) {
			return true;
		}
		else {
			if (s.charAt(0) != s.charAt(1))
				return false;
			else
				return recursiveAllCharactersSame(s.substring(1));
		}
	}

	/**
	 * Q7: recursive method that returns the number of characters in the 
	 *     String, which may be 0
	 */
	public static int recursiveCount(char c, String s) {
		if (s == null || s.length() == 0)
			return 0;
		else if (s.length() == 1)
			return (s.charAt(0) == c? 1 : 0);
		else 
			return  (s.charAt(0) == c? 1 : 0) + recursiveCount(c, s.substring(1));
	}
}
