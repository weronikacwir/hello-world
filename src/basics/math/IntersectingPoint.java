package basics.math;

import java.util.Scanner;

public class IntersectingPoint {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print
			("Enter coordinates of two points on a line: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		//Find slope and intercept of the line 
		//through point (x1, y1) and (x2, y2)
		double s1 = getSlope(x1, y1, x2, y2);
		double i1 = getIntercept(s1, x1, y1);
		
		System.out.print
			("Enter coordinates of two more points: ");
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double x4 = input.nextDouble();
		double y4 = input.nextDouble();
		
		//Find slope and intercept of the line 
		//through point (x3, y3) and (x4, y4)
		double s2 = getSlope(x3, y3, x4, y4);
		double i2 = getIntercept(s2, x3, y3);
		
		//Print out line equations
		System.out.println(lineToString(s1, i1));
		System.out.println(lineToString(s2, i2));
				
		//See if the lines intercept - i.e. whether 
		//
		//    s1x + i1 = s2x + i2
		//
		//has a real solution. If so, solve for x and y 
		//- i.e. point of intersection - using Cramer's rule
		String result = "The lines ";
		
		double determinant = s1 - s2;
		
		if (Math.abs(determinant) < 1E-14) {
			//If the slopes are the same, the lines do not intersect
			result += "are parallel.";
		} else {
			//     intercept2 - intercept1
			// x = -----------------------
			//         slope1 - slope2
			//
			double x = (i2 - i1) / determinant;
			
			//     slope1*intercept2 - slope2*intercept1
			// y = -------------------------------------
			//            slope1 - slope2
			//
			double y = (s1*i2 - s2*i1) / determinant;
			result += 
					("intersect at (" + x + ", " + y + ").");
		}
		
		System.out.println(result);		
	}
	
	/*
	 * returns String version of linear equation with 
	 * slope m and intercept i
	 * "y = mx + i"
	 */
	private static String lineToString(double m, double i) {
		String equation = "y = " + m + "x ";
		equation += (i >= 0)? "+ " + i : "- " + Math.abs(i);
		return equation;
	}
	
	
	/*
	 * returns slope of line through (x, y) and (u, v)
	 */
	private static double getSlope(double x, double y, double u, double v) {
		return (u-x) / (v-y);
	}
	
	/*
	 * returns intercept of line with slope m through point (x, y)
	 */
	private static double getIntercept(double m, double x, double y) {
		return y - m*x;
	}
	
	
}
