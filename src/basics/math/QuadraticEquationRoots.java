package basics.math;

import java.util.Scanner;

public class QuadraticEquationRoots {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a, b, c as doubles: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		
		if (a == 0) {
			System.out.println("a can't equal 0.");
			System.exit(-1);
		}
		
		String equation = "";
		if (a != 0) 
			equation += (a + "x^2");
		if (b != 0)
			equation += (((b > 0)? " + " : " - ") + Math.abs(b) + "x");
		if (c != 0)
			equation += (((c > 0)? " + " : " - ") + Math.abs(c));
		
		double discriminant = b*b - 4*a*c;
		String message = " has ";
		if (discriminant < 0) {
			message += "no real roots.";	
		} else if (discriminant == 0) {
			double root = -b / (2*a);
			message += ("one root " + root);
		} else {
			double root1 = (-b + Math.sqrt(discriminant)) / (2*a);
			double root2 = (-b - Math.sqrt(discriminant)) / (2*a);
			message += ("two real roots " + root1 + " and " + root2);
		}
		
		System.out.println(equation + message);
		
	}

}
