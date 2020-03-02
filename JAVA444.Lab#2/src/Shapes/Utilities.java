package Shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {

	private static int shapesCreated = 0;

	public static void readFile(Shapes[] arrayHolder, boolean show) {// read file function
		shapesCreated = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			String s;
			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");
				try {
					if (tokens[0].equals("Circle") && tokens.length == 2) {// check object type
						Shapes circle = new Circle(Double.parseDouble(tokens[1]));// create circle instance of Shape
						arrayHolder[shapesCreated] = circle;// store circle instance into array
						shapesCreated++;// increase shapes created
					} else if (tokens[0].equals("Square") && tokens.length == 2) {
						Shapes square = new Square(Double.parseDouble(tokens[1]));
						arrayHolder[shapesCreated] = square;
						shapesCreated++;

					} else if (tokens[0].equals("Rectangle") && tokens.length == 3) {
						Shapes rectangle = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						arrayHolder[shapesCreated] = rectangle;
						shapesCreated++;

					} else if (tokens[0].equals("Parallelogram") && tokens.length == 3) {
						Shapes parallelogram = new Parallelogram(Double.parseDouble(tokens[1]),
								Double.parseDouble(tokens[2]));
						arrayHolder[shapesCreated] = parallelogram;
						shapesCreated++;
					} else if (tokens[0].equals("Triangle") && tokens.length == 4) {
						Shapes triangle = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
								Double.parseDouble(tokens[3]));
						arrayHolder[shapesCreated] = triangle;
						shapesCreated++;
					}

				} catch (CircleException errorMessage) {
					if (show)
						System.out.println(errorMessage.getMessage());// print out error message
				} catch (TriangleException errorMessage) {
					if (show)
						System.out.println(errorMessage.getMessage());
				} catch (SquareException errorMessage) {
					if (show)
						System.out.println(errorMessage.getMessage());
				} catch (RectangleException errorMessage) {
					if (show)
						System.out.println(errorMessage.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void print(Shapes[] arrayHolder) {// print all array if instance is not null
		for (int i = 0; i < arrayHolder.length; ++i) {
			if (arrayHolder[i] != null) {
				System.out.println(arrayHolder[i]);// print object will call the toString() method overridden in each //
													// class
				System.out.println();
			}
		}
	}

	public static void parseArray(Shapes[] arrayHolder) {// used to remove getPerimeters min and max
		double min = 0;
		double max = 0;
		for (int i = 0; i < arrayHolder.length; ++i) {// set first minimum number for Triangle
			if (arrayHolder[i] instanceof Triangle && (arrayHolder[i].getPerimeter() < min || min == 0)) {
				min = arrayHolder[i].getPerimeter();
			}
		}
		for (int i = 0; i < arrayHolder.length; ++i) {// set all Triangles with minimum getPerimeter to null
			if (arrayHolder[i] instanceof Triangle && arrayHolder[i].getPerimeter() == min) {
				arrayHolder[i] = null;
			}
		}
		for (int i = 0; i < arrayHolder.length; ++i) {// set starting point to find max Circle
			if (arrayHolder[i] instanceof Circle && arrayHolder[i].getPerimeter() > max) {
				max = arrayHolder[i].getPerimeter();

			}
		}
		for (int i = 0; i < arrayHolder.length; ++i) {// set all Circle to null with maximum getPerimeter
			if (arrayHolder[i] instanceof Circle && arrayHolder[i].getPerimeter() == max) {
				arrayHolder[i] = null;
			}
		}
	}

	public static int getShapesCreated() {// get total shapes created
		return shapesCreated;
	}

	public static double trigetPerimeter(Shapes[] arrayHolder) {// calculate total getPerimeter of triangle
		double sum = 0;
		for (Shapes i : arrayHolder) {
			if (i instanceof Triangle && i != null) {// add all instances of Triangle getPerimeter
				sum += i.getPerimeter();
			}
		}
		return sum;
	}

	public static double paragetPerimeter(Shapes[] arrayHolder) {// calculate total getPerimeter of parallelogram
		double sum = 0;
		for (Shapes i : arrayHolder) {
			if (i instanceof Parallelogram && i != null) {// add all instances of Triangle getPerimeter
				sum += i.getPerimeter();
			}
		}
		return sum;

	}

}
