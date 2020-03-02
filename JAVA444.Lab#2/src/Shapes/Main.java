package Shapes;

import java.util.Arrays;

public class Main {
	static Shapes[] arrayHolder = new Shapes[35];// set array to length 35
	public static void main(String[] args) {
		
		System.out.println("------->JAC 444 Assignment 1<-------\r\n" + "------->Task 1 ... <------- ");
		Utilities.readFile(arrayHolder, true);
		System.out.println("\n" + Utilities.getShapesCreated() + " shapes were created:");
		Utilities.print(arrayHolder);
		
		Arrays.fill(arrayHolder, null);//clear data members before running each task				
		System.out.println("------->Task 2 ... <-------");
		Utilities.readFile(arrayHolder, false);
		Utilities.parseArray(arrayHolder);
		Utilities.print(arrayHolder);// print out all instances of that are not set to null
		
		Arrays.fill(arrayHolder, null);
		System.out.println("------->Task 3 ... <-------");
		Utilities.readFile(arrayHolder, false);
		Utilities.parseArray(arrayHolder);		
		System.out.println("Total perimeter of Parallelogram is: " + Utilities.paragetPerimeter(arrayHolder));
		System.out.println("Total perimeter of Triangle is: " + Utilities.trigetPerimeter( arrayHolder));
		

	}// end of main
}
