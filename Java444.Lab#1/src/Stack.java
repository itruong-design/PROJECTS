public class Stack {
    private char[] arr;
    private String orgString;
    
//Pushes the String into 'orgString' data member 
    Stack(String str){
    	arr = new char[str.length()];
    	push(str);
    	
    	orgString = str;
    	
    };
    
//gets Original String 
public String get() {
	return orgString;
}


public void push(String str) {
	char[] tempArr =  str.toCharArray(); //populates 'tempArr' Array from 'Str' Array left to write
	
	for(int i = 0 ; i < tempArr.length ; i++) {
		arr[i] = tempArr[i];  
	}
	
}

//Once function complete returns the last element and shortens the length by one
public char pop() {
	char tempArr[] = new char [arr.length - 1]; //creates new char Temp. array
	
	char lastChar = arr[arr.length - 1];  //grabs last element of the array
	
	for(int i = 0 ; i < tempArr.length ; i++) {
		tempArr[i] = arr[i];
	}
	arr = tempArr;
	
	return lastChar; //returns the last character of the Original array 
}

//check my array if it is empty
public boolean isEmpty() {
	if(arr.length != 0) {
		return false;
	}
	return true;
}
}
