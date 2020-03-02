package Student;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses = new ArrayList<String>();
	
	//
	//constructors
	public Student() {//used to instantiate with no arguments passed
		this.stdID = 0;
		this.firstName= " ";
		this.lastName= " ";
	}
	public Student (int stdID, String firstName, String lastName, ArrayList<String> courses) throws StudentException {
		if (stdID < 0 || firstName == " " || lastName == " " || courses.isEmpty()) {
			throw new StudentException("Invalid data was entered for student");
		} else {
			this.stdID = stdID;
			this.firstName = firstName;
			this.lastName = lastName;
			for (String i : courses) {
				this.courses.add(i);
			}
		}
	}

	//
	// getters
	public int getStdID() {
		return this.stdID;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public ArrayList<String> getCourses() {
		return this.courses;
	}
	//
	//returns a single course based on string that is passed
	public String getSingleCourse(String courseName) throws StudentException {
		if (courseName.equals(" ")) {
			throw new StudentException("Input a valid course name that is not empty");
		} else {
			for (String i : this.courses) {
				if (i.equals(courseName)) {
					return i;

				}
			}
			throw new StudentException("Student does not have specified course");
		}
		
	}

	public void setStdID(int stdID) throws StudentException {
		if (stdID < 0) {
			throw new StudentException("Invalid student ID member");
		} else {
			this.stdID = stdID;
		}
	}

	public void setFirstName(String firstName) throws StudentException {
		if (firstName == " ") {
			throw new StudentException("Invalid First Name ");
		} else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) throws StudentException {
		if (lastName == " ") {
			throw new StudentException("Invalid Last Name");
		} else {
			this.lastName = lastName;
		}
	}

	public void setCourses(ArrayList<String> courses) throws StudentException {
		if (courses.isEmpty()) {
			throw new StudentException("List of Courses is empty");
		} else {
			for (String i : courses) {
				this.courses.add(i);
			}
		}
	}
	//
	//sets a single course to ArrayList of courses based on string that is passed
	public void setSingleCourse(String courseName) throws StudentException{
		if(courseName.equals(" ")) {
			throw new StudentException("Invalid course to add");
		}else {
			this.courses.add(courseName);
			
		}
	}
	//public int sizeCourses() {
	//return courses.size();		
	//}
	//
	//public String getSingleCourse(int index) {
	//String c = courses.get(index);
	//return c;
	//}
}


////package Student;
////import java.util.ArrayList;
////
////	
////	public class Student implements java.io.Serializable{
////	
////		/**
////		 * 
////		 */
////		private static final long serialVersionUID = 1L;
////		private int StudentID;
////		private String firstName;
////		private String lastName;
////		private ArrayList<String> courses = new ArrayList<String>();
////		
////		
////		public Student() {
////			
////			this.StudentID = 0;
////			this.firstName = " ";
////			this.lastName = " ";
////			courses = new ArrayList<String>();
////		}
////		
////		public Student(int id ,String first ,String last )  {
////				
////				this.firstName = first;
////				this.StudentID = id;
////				this.lastName = last;
////				this.courses = new ArrayList<String>();
////			}
////		
////		
////		//StudentID
////		public int getStudentID() {
////			return StudentID;
////		}
////
////
////		public void setStudentID(int studentID) {
////			StudentID = studentID;
////		}
////
////		//FirstName
////		public String getFirstName() {
////			return firstName;
////		}
////
////
////		public void setFirstName(String firstName) {
////			this.firstName = firstName;
////		}
////
////		//LastName
////		public String getLastName() {
////			return lastName;
////		}
////
////
////		public void setLastName(String lastName) {
////			this.lastName = lastName;
////		}
////
////		//courses
////		public ArrayList<String> getCourses() {
////			return courses;
////		}
////
////
////		public void  addCourses(String courses) {
////			this.courses.add(courses);
////		}
////

