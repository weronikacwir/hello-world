package basics.math;

import java.util.Scanner;


public class IntersectingPointVersion1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter x1, y1, x2, y2 on line 1: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		System.out.print("Enter x3, y3, x4, y4 on line 2: ");
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double x4 = input.nextDouble();
		double y4 = input.nextDouble();
		input.close();
		
		
		//The intersecting point, if it exists, is given 
		//by solution to the linear equation:
		//
		// (y1-y2)x - (x1-x2)y = (y1-y2)x1 - (x1-x2)y1
		// (y3-y4)x - (x3-x4)y = (y3-y4)x3 - (x3-x4)y3
		LinearEquation el = 
				new LinearEquation(y1-y2, -(x1-x2), y3-y4, -(x3-x4),
					(y1-y2)*x1 - (x1-x2)*y1, (y3-y4)*x3 - (x3-x4)*y3);
		
		if(el.isSolvable())
			System.out.printf
				("The lines intersect at (%f, %f)", el.getX(), el.getY());
		else
			System.out.println("The lines are parallel.");

	}

}
