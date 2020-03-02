package Shapes;


public class Square implements Shapes {
	private double m_length;
	private Area obj = () -> {return Math.pow(getLength(), 2);};

//constructors

	Square(double length) throws SquareException{// overload constructor
		if (length > 0) {
			this.m_length = length;
		} else {
			throw new SquareException("Invalid side(s)!");// custom exception message
		}
	}

//end of constructors
	public double getPerimeter() {
		return this.getLength() * 4;
	}
	public double getArea() {
		return obj.area();
	}

//setters and getters
	public double getLength() {
		return this.m_length;
	}

	public void setLength(double length) throws SquareException{
		if(length >0 ) {
		this.m_length = length;
		}{
			throw new SquareException("Invalid side(s)!");
		}
	}

//end of setters and getters
	@Override // over ride toString() method to print string when system.out.println object
	public String toString() {
		return "Square" + " {s=" + getLength() + "} perimeter = " + getPerimeter()+ " area = " + obj.area();

	}

}


//package Shapes;
//
//public class Square implements Shapes {
//	
//	private double length;	
//	
//	public Square() {
//		length = 0; 
//	}
//	
//	public Square (double lenght) throws SquareException {
//		
//		if(lenght > 0) {
//			this.length = lenght;
//		}
//		else {
//			throw new SquareException("Invalid Side(s)");
//		}
//		
//	}
//
//	@Override
//	public double getPerimeter() {
//		// TODO Auto-generated method stub
//		return 4 * length; 
//	} 
//	
//	public double getLength() {
//		return length;
//	}
//	
//	public void setLength(double length) throws SquareException{
//		if(length > 0) {
//			this.length = length;
//		}
//		else {
//			throw new SquareException("Invalid Side(s)");
//		}
//	}
//	
//	public String toString() {
//		return " Square {s = " + getLength() + " } Perimeter " + getPerimeter();	
//	}	
//}