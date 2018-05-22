package basics.math;

import java.util.Scanner;

public class LinearEquation {
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	
	public LinearEquation
		(double a, double b, double c, double d, double e, double f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}
	
	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
	
	public double getC() {
		return c;
	}
	
	public double getD() {
		return d;
	}
	
	public double getE() {
		return e;
	}
	
	public double getF() {
		return f;
	}
	
	public boolean isSolvable() {
		return (Math.abs(a*d - b*c) > 1E-14);
	}
	
	public double getX() {
		return isSolvable()?
			(e*d - b*f) / (a*d - b*c)
			: Double.NaN;
	}
	
	public double getY() {
		return isSolvable()? 
			(a*f - e*c) / (a*d - b*c) 
			: Double.NaN;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a, b, c, d, e, f: ");
		double _a = input.nextDouble();
		double _b = input.nextDouble();
		double _c = input.nextDouble();
		double _d = input.nextDouble();
		double _e = input.nextDouble();
		double _f = input.nextDouble();
		input.close();
		
		LinearEquation le = new LinearEquation(_a, _b, _c, _d, _e, _f);
		
		if(le.isSolvable())
			System.out.printf("x = %f\ny = %f", le.getX(), le.getY());
		else
			System.out.println("The equation has no solution.");

	}

}
