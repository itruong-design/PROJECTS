package Shapes;


public class Rectangle extends Square {
	private double m_width;
	private Area obj = () -> {return getLength() * getWidth();};

//constructors

	Rectangle(double width, double length) throws RectangleException, SquareException {// overloaded constructor
		super(length);// called superClass Square constructor
		if (width > 0 && length > 0) {
			this.m_width = width;
		} else {
			throw new RectangleException("Invalid length or width");// customer exception message

		}
	}

//end of constructors
	public double getPerimeter() {
		return (getLength() * 2) + (this.getWidth() * 2);// 2*length + 2*width
	}
	public double getArea() {
		return obj.area();
	}

//setters and getters

	public double getWidth() {
		return this.m_width;
	}

	public void setWidth(double width) throws RectangleException {
		if (width > 0) {
			this.m_width = width;
		} else {
			throw new RectangleException("Invalid Width");
		}
	}

//end of setters and getters
	@Override // over ride toString() method to print string when system.out.println object
	public String toString() {
		return "Rectangle" + " {w=" + getWidth() + ", l=" + getLength() + "} " + "perimeter = "
				+ getPerimeter() + " area = " + obj.area();

	}

}


//package Shapes;
//
//public class Rectangle extends Square {
//
//	private double width;
//	private double length;
//	
//	public Rectangle() {
//		width = 0;
//		length = 0;
//	}
//	
//	public Rectangle(double len , double wid) throws RectangleException {
//		if (wid > 0 && len > 0 ) {
//			this.width = wid;
//			this.length = len; 
//			
//			
//		}else {
//			throw new RectangleException("Invalid side(s) ");
//		}
//	}
//	
//	@Override
//	public double getPerimeter() {
//		// TODO Auto-generated method stub
//		return (2 * getLength()) + (2 * getWidth());
//	}
//	
//	public double getLength() {
//		return this.length;
//		
//	}
//	
//	@Override
//	public void setLength(double len){
//		if(length > 0) {
//			this.length = len;	
//		}
//		else {
//			
//		}
//	}
//	
//	public double getWidth() {
//		return this.width;			
//	}
//	
//	public void setWidth(double width) {	
//		this.width = width;
//	}
//	
//	public String toString() {
//		return "Rectangle" + "{w= " + getWidth() + ", l=" + getLength() + "} " 
//				+ "perimeter" + getPerimeter();              
//	}
//}