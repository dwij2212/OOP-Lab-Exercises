import java.util.LinkedList;

public class Stack {
	public LinkedList<Object> elements;

	public Stack() {
		// TODO Auto-generated constructor stub
		elements = new LinkedList<Object>();
	}

	public Stack(Object o) {
		// TODO Auto-generated constructor stub
		elements = new LinkedList<Object>();
		elements.addFirst(o);
	}

	public void push(Object o) {
		elements.addFirst(o);
		System.out.println("Inserted " + o.toString());
	}

	public void pop() {
		Object object = elements.removeFirst();
		System.out.println("Removed " + object.toString());
	}

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.pop();
		stack.push(5);
		stack.push(6);
		stack.pop();
	}
}
