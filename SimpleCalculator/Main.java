package calculator;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Operation operation = new Operation();
		boolean choice = true;
		while (choice) {
			System.out.println("----------------------------------");
			System.out.println(
					"1.Addition\n2.Subraction\n3.Multiplication\n4.Division\n5.Sin\n6.Cos\n7.Tan\n8.Log\n9.SquareRoot\n10.CubeRoot\n11.Factorial\n12.Exit");
			System.out.println("----------------------------------");
			int userinput = in.nextInt();
			switch (userinput) {
			case 1: {
				operation.addition();
				break;
			}
			case 2: {
				operation.subraction();
				break;
			}
			case 3: {
				operation.multiply();
				break;
			}
			case 4: {
				operation.division();
				break;
			}
			case 5: {
				operation.sin();
				break;
			}
			case 6: {
				operation.cos();
				break;
			}
			case 7: {
				operation.tan();
				break;
			}
			case 8: {
				operation.log();
				break;
			}
			case 9: {
				operation.squareRoot();
				break;
			}
			case 10: {
				operation.CubeRoot();
				break;
			}
			case 11: {
				operation.factorial();
				break;
			}
			case 12: {
				choice = false;
				break;
			}
			default: {
				System.out.println("Please Enter Correct Choice...!");
				break;
			}

			}

		}
	}

}
