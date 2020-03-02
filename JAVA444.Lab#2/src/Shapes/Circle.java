package Shapes;

public class Circle implements Shapes {
	
	private double m_radius;
	private Area obj = () -> {return (Math.PI * Math.pow(getRadius(), 2));};
	


	public Circle(double radius) throws CircleException {// overloaded constructor
		if (radius >= 0) {
			this.m_radius = radius;
		} else {
			throw new CircleException("Invalid radius");
		}
	}


	public double getPerimeter() {
		return Math.PI * (2 * this.getRadius());
	}
	
	public double getArea() {
		return obj.area();
	}


	public double getRadius() {
		return this.m_radius;
	}

	public void setRadius(double radius) throws CircleException {
		if (radius > 0) {
			this.m_radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}


	@Override // over ride toString() method to print string when system.out.println object
	public String toString() {
		return "Circle" + " {r=" + getRadius() + "} perimeter = " + getPerimeter() + " area = " + obj.area();
	}
}

