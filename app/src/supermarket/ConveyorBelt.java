package supermarket;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConveyorBelt<T> {

	private final Object[] elements;
	private int amount, begin, end;
	private final Lock lock = new ReentrantLock();
	private final Condition empty = lock.newCondition();

	public ConveyorBelt(int size) {
		elements = new Object[size];
		amount = 0;
		begin = 0;
		end = 0;
	}

	public void putIn(T item) {
		elements[end] = item;
		end = (end + 1) % elements.length;
		amount = amount + 1;
	}

	public T removeFrom() { // Assumes there is at least one element
		T item = (T) elements[begin];
		begin = (begin + 1) % elements.length;
		amount = amount - 1;
		return item;
	}
}
