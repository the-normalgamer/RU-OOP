package supermarket;

public class ConveyorBelt {

	private final Object[] elements;
	private int amount, begin, end;

	public ConveyorBelt(int size) {
		elements = new Object[size];
		amount = 0;
		begin = 0;
		end = 0;
	}

	public void putIn(Object item) {
		elements[end] = item;
		end = (end + 1) % elements.length;
		amount = amount + 1;
	}

	public Object removeFrom() { // Assumes there is at least one element
		Object item = elements[begin];
		begin = (begin + 1) % elements.length;
		amount = amount - 1;
		return item;
	}
}
