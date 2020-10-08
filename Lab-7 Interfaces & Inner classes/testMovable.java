interface Movable { // saved as movable.java
	public void moveUp();
	
	// On providing concrete function logic, the class overrides this similarly
	public default void moveLeft() {
		System.out.println("GG");
	}
	public void moveRight();
	public void moveDown();
}

class MovablePoint implements Movable {
	int x, y, xSpeed, ySpeed;

	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		super();
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public void moveUp() {
		y += ySpeed;
	}
	
	public void moveDown() {
		y -= ySpeed;
	}
	
	public void moveLeft() {
		x -= xSpeed;
	}
	
	public void moveRight() {
		x += xSpeed;
	}
	
	@Override
	public String toString() {
		return "Point co-ordinates: (" + x + ", " + y + ")";
	}
}

class MovableCircle implements Movable {
	
	private MovablePoint center;
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed) {
		// Call the MovablePoint's constructor to allocate the center instance.
		center = new MovablePoint(x, y, xSpeed, ySpeed);
	}
		// Implement abstract methods declared in the interface Movable
	public void moveUp() {
		center.y += center.ySpeed;
	}
	
	public void moveDown() {
		center.y -= center.ySpeed;
	}
	
	public void moveLeft() {
		center.x -= center.xSpeed;
	}
	
	public void moveRight() {
		center.x += center.xSpeed;
	}
	
	
	@Override
	public String toString() {
		return "Circle co-ordinates: (" + center.x + ", " + center.y + ")";
	}
	
}

public class testMovable {

	public static void main(String[] args) {
		Movable m1 = new MovablePoint(5, 6, 10, 20); // upcast
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		
		Movable m2 = new MovableCircle(2, 1, 2, 20); // upcast
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);
	}

}
