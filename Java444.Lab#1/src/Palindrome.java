import java.lang.String;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	String temp = "";
    	String reverseString = "";
    	
    	
    	System.out.print(" Enter Word : ");
    	  	
    	temp = input.next();
    	Stack obj = new Stack(temp);
	
    	while(! obj.isEmpty()) {
  
    		char tempWord = obj.pop();
    		
    		String tempString = Character.toString(tempWord);  
    		//taking the character library to converts the character variable to a string
    		
    		reverseString += tempString;	
    		
    	}
    	
    	if(reverseString.equals(obj.get())) {
    		System.out.println("String is Palindrome"); 		
    	}
    	else {
    		System.out.println("String is not a Palindrome");
    	}
    	
    	
    }
}


