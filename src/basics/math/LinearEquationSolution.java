package basics.math;

import java.util.Scanner;

public class LinearEquationSolution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print
			("Enter a, b, c, d, e, f: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();
		
		double determinant = a*d - b*c;
		if (determinant == 0) {
			System.out.println
				("The equation has no solution.");
			System.exit(0);
		}
		
		double x = (e*d - b*f) / determinant;
		double y = (a*f - e*c) / determinant;
		
		System.out.printf("x is %f and y is %f", x, y);
		
	}

}
