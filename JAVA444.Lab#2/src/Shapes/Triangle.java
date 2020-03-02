package Shapes;


public class Triangle implements Shapes {
	private double m_sideA;
	private double m_sideB;
	private double m_sideC;
	private double m_height;

//constructors
	Triangle(double sideA, double sideB, double sideC) throws TriangleException {// overloaded constructor
		if (sideA > 0 && sideB > 0 && sideC > 0 && ((sideA + sideB) > sideC)) {
			this.m_sideA = sideA;
			this.m_sideB = sideB;
			this.m_sideC = sideC;
			this.m_height = 0;
		} else {
			throw new TriangleException("Invalid side!");// custom exception message

		}
	}

//end of constructors
	public double getPerimeter() {
		return this.getSideA() + this.getSideB() + this.getSideC();// sideA + sideB + sideC
	}
//setters and getters
	public double getSideA() {
		return this.m_sideA;
	}

	public void setSideA(double sideA) throws TriangleException {
		if (sideA > 0) {
			this.m_sideA = sideA;
		} else {
			throw new TriangleException("Invalid Side!");
		}
	}

	public double getSideB() {
		return this.m_sideB;
	}

	public void setSideB(double sideB) throws TriangleException {
		if (sideB > 0) {
			this.m_sideB = sideB;
		} else {
			throw new TriangleException("Invalid side!");
		}
	}

	public double getSideC() {
		return this.m_sideC;
	}

	public void setSideC(double sideC) throws TriangleException {
		if (sideC > 0) {
			this.m_sideC = sideC;

		} else {
			throw new TriangleException("Invalid side!");
		}
	}

	public double getHeight() {
		return this.m_height;
	}

	public void setHeight(double height) throws TriangleException {
		if (height > 0) {
			this.m_height = height;
		} else {
			throw new TriangleException("Invalid height");
		}
	}

//end of setters and getters
	@Override // over ride toString() method to print string when system.out.println object
	public String toString() {
		return "Triangle" + " {s1=" + getSideA() + ", s2=" + getSideB() + ", s3=" + getSideC() + "} "
				+ "perimeter = " + getPerimeter();
				
				
	}

}


//package Shapes;
//
//public class Triangle implements Shapes {
//
//	private double m_sideA;
//	private double m_sideB;
//	private double m_sideC;
//	private double m_height;
//
//	public Triangle() {
//		this.m_sideA = 0;
//		this.m_sideB = 0;
//		this.m_sideC = 0;
//		this.m_height = 0;
//	}
//
//	public Triangle(double sideA, double sideB, double sideC) throws TriangleException {	
//		if(sideA > 0 && sideB > 0 && sideC > 0) {
//		this.m_sideA = sideA;
//		this.m_sideB = sideB;
//		this.m_sideC = sideC;
//
//		this.m_height = 0;
//		}
//		else {
//			throw new TriangleException("Invalid Side(s) ");
//		}
//	}
//
//	@Override
//	public double getPerimeter(){
//		return this.m_sideA + this.m_sideB + this.m_sideC;
//	}
//
//	public double getSideA() {
//		return this.m_sideA;
//	}
//
//	public void setSideA(double sideA) {
//		this.m_sideA = sideA;
//	}
//
//	public double getSideB() {
//		return this.m_sideB;
//	}
//
//	public void setSideB(double sideB) {
//		this.m_sideB = sideB;
//	}
//
//	public double getSideC() {
//	return this.m_sideC;
//	}
//
//	public void setSideC(double sideC) {
//		this.m_sideC = sideC;
//	}
//
//	public double getHeight() {
//		return this.m_height;
//	}
//
//	public void setHeight(double height) {
//		this.m_height = height;
//	}
//
//	public String toString() {
//		return "Triangle" + " {s1=" + getSideA() + ", s2=" + getSideB() + ", s3=" + getSideC() + "} "
//				+ "perimeter = " + getPerimeter();
//	}
//}
//
///*package Shapes;
//
//public class Triangle implements Shapes{
//	
//	private double sideA;
//	private double sideB;
//	private double sideC;
//	
//	
//	Triangle(double a , double b , double c , double h) throws TriangleException {
//		if (a > 0 && b > 0 && c > 0 && h > 0) {
//			this.sideA = a;
//			this.sideB = b;
//			this.sideC = c;
//			
//		}
//		
//	}
//	
//	
//	@Override
//	public double getPerimeter() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//	
//} */