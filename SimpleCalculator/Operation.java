package calculator;

import static java.lang.Math.sqrt;
import static java.lang.Math.cbrt;
import static java.lang.Math.log10;

import java.util.Scanner;

class Operation  {

	public void addition() {

		Scanner in = new Scanner(System.in);
		int input1 = in.nextInt();
		int input2 = in.nextInt();
		System.out.println("Addition is: " + (input1 + input2));
		
	}

	public void subraction() {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number 1: ");
		int input1 = in.nextInt();
		System.out.println("Enter Number 2: ");
		int input2 = in.nextInt();
		System.out.println("Subraction is: " + (input1 - input2));

	}

	public void multiply() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number 1: ");
		int input1 = in.nextInt();
		System.out.println("Enter Number 2: ");
		int input2 = in.nextInt();
		System.out.println("Multiplication is: " + (input1 * input2));
	}

	public void division() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Dividend: ");
		double input1 = in.nextDouble();
		System.out.println("Enter Divisor: ");
		double input2 = in.nextDouble();
		System.out.println(" Quotient is: " + (input1 / input2));
		System.out.println(" Remainder is: " + (input1 % input2));
	}

	public void squareRoot() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number: ");
		Double input1 = in.nextDouble();
		System.out.println("Square root is: " + (sqrt(input1)));
	}

	public void log() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number: ");
		Double input1 = in.nextDouble();
		System.out.println("log 10 is: " + (log10(input1)));
	}

	public void tan() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number: ");
		Double input1 = in.nextDouble();
		System.out.println("Tan  is: " + (Math.tan(input1)));
	}

	public void sin() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number: ");
		Double input1 = in.nextDouble();
		System.out.println("Sin  is: " + (Math.sin(input1)));
	}

	public void cos() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number: ");
		Double input1 = in.nextDouble();
		System.out.println("Cos is: " + (Math.cos(input1)));
	}

	public void CubeRoot() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number: ");
		Double input1 = in.nextDouble();
		System.out.println("Cube Root is: " + (cbrt(input1)));
	}

	public void factorial() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number: ");
		int input1 = in.nextInt(), fact = 1;
		for (int i = 1; i <= input1; i++) {
			fact = fact * i;
		}
		System.out.println("factorial is: " + fact);
	}

}
