package Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestStudent {
	public static void main(String[] args) {
		//
		// testing writing to a file
		if (args.length == 0) {
			System.out.println("There are no files in arguments");
		} else {
			// testStudent();
			// testWriting(args[0]);
			//testReading(args[0]);
		}

	}

	//
	// test Student class is working properly
	public static void testStudent() {
		int stdID = 999;
		String firstName = "Danny";
		String lastName = "Nguyen";
		ArrayList<String> courses = new ArrayList<String>(
				Arrays.asList("SYS466", "EAC594", "BCI433", "JAC444", "WEB422"));
		Student obj = null;
		try {
			obj = new Student(stdID, firstName, lastName, courses);
			printStudentInfo(obj);

		} catch (StudentException message) {
			System.out.println(message.getMessage());
		}
	}

	//
	// test if writing to file is working properly
	public static void testWriting(String fileName) {

		Student obj2 = new Student();
		File file;
		FileWrite fileWrite;
		try {
			userInputStudentRecord(obj2);
			file = new File(fileName);
			fileWrite = new FileWrite(file);
			// fileWrite.write(obj2);// write user input into file
			fileWrite.serializeObject(obj2);
		} catch (FileNotFoundException message) {
			System.out.println(message.getMessage());
		} catch (IOException message) {
			System.out.println(message.getMessage());
		} catch (FileWriteException message) {
			System.out.println(message.getMessage());
		} catch (StudentException message) {
			System.out.println(message.getMessage());
		}
	}

	public static void testReading(String fileName) {
		FileRead fileRead;
		File file;
		try {
			file = new File(fileName);
			fileRead = new FileRead(file);
			System.out.println(fileRead.deserializeObject().getStdID());
			System.out.println(fileRead.deserializeObject().getFirstName());
			System.out.println(fileRead.deserializeObject().getLastName());
			System.out.println(fileRead.deserializeObject().getCourses());

		} catch (FileReadException message) {
			System.out.println(message.getMessage());
		} catch (FileNotFoundException message) {
			System.out.println(message.getMessage());
		} catch (ClassNotFoundException message) {
			System.out.println(message.getMessage());
		} catch (StreamCorruptedException message) {
			System.out.println(message.getMessage());
		} catch (IOException message) {
			System.out.println(message.getMessage());
		}
	}

	//
	// get user input into an object
	public static void userInputStudentRecord(Student object) throws StudentException {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Please enter Student ID: ");
		object.setStdID(scan.nextInt());
		System.out.printf("Please enter First Name: ");
		object.setFirstName(scan.next());
		System.out.printf("Please enter Last Name: ");
		object.setLastName(scan.next());
		System.out.println("Please enter list of courses (Press 0 when finished)");
		while (!scan.hasNextInt()) {
			object.setSingleCourse(scan.next());
		}
		scan.close();
		System.out.println("End of user input");

	}

	public static void printStudentInfo(Student obj) {
		System.out.println("Student ID: " + obj.getStdID());
		System.out.println("Full Name: " + obj.getFirstName() + " " + obj.getLastName());
		System.out.printf("Courses: ");
		for (String i : obj.getCourses()) {
			System.out.printf("%s ", i);
		}
		System.out.println();
	}

}

//package Student;
//import java.util.Scanner;
//import java.io.IOException;
//
//public class TestStudent extends FileWrite {
//		
//		public static void main(String[] args) {	
//				
//			
//			Scanner readline = new Scanner(System.in);
//			String reading;
//			try {
//				System.out.print("Press w to write to file Or Press r to read to file :");
//				
//				reading = readline.next();
//				
//				if(reading.equals("r")) {
//					readFile(args[0]);
//					
//				}else if(reading.equals("w")) {
//					System.out.println("Enter Student Information *Press q to Quit*  ");
//					write(args[0]);	
//				}
//		
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				System.out.print(e.getMessage());
//			}
//			
//			
//			
//		}
//	
//}