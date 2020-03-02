package Shapes;

public class Parallelogram extends Rectangle {
	private double m_height;

//constructors
	Parallelogram(double length, double height) throws RectangleException, SquareException {// overloaded constructor
		super(length, height);// called superClass Square constructor
		if (height > 0) {
			this.m_height = height;
		} else {
			throw new RectangleException("Invalid height");// custom exception message

		}
	}

//end of constructors

//setters and getters
	public double getHeight() {
		return this.m_height;
	}

	public void setHeight(double height) throws RectangleException {
		if (height > 0) {
			this.m_height = height;
		} else {
			throw new RectangleException("Invalid height");
		}
	}

//end of setters and getters
	@Override // over ride toString() method to print string when system.out.println object
	public String toString() {
		return "Parallelogram" + " {w=" + getWidth() + ", h=" + getHeight() + "} " + "perimeter = "
				+ super.getPerimeter();

	}

}


//package Shapes;
//
//public class Parallelogram extends Rectangle {
//	
//	private double height; 
//	private double length;
//	
//	public Parallelogram(double hei , double len) throws ParallelogramException {		
//		if(hei > 0 && len > 0) {
//			this.height = hei;
//			this.length = len;	
//		}
//		else {
//			throw new ParallelogramException("Invalid Side(s)");
//		}
//	}
//	
//	public double getLength() {
//		return this.length;		
//	}
//	
//	public void setLength(double len) {
//		if(length > 0) {
//			this.length = len;			
//		}
//	}
//	
//	public double getHeight() {
//		return this.height;		
//	}
//	
//	public void setHeight(double hei) throws ParallelogramException{
//		if(length > 0) {
//			this.height = hei;
//			
//		}else {
//			throw new ParallelogramException("Height ");
//		}
//	}
//	
//	public String toString() {
//		return "Paralleogram {w= " + getLength() + ", h= " + getHeight() + "} Perimeter " + getPerimeter();
//	}
//}
//	