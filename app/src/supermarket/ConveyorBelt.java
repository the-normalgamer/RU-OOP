package supermarket;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConveyorBelt<T> {

	private final Object[] elements;
	private int amount, begin, end;
	private final Lock lock = new ReentrantLock();
	private final Condition notEmpty = lock.newCondition();
	private final Condition notFull = lock.newCondition();

	public ConveyorBelt(int size) {
		elements = new Object[size];
		amount = 0;
		begin = 0;
		end = 0;
	}

	public void putIn(T item) {
		lock.lock();
		try {
			while (amount == elements.length) notFull.await();

			elements[end] = item;
			end = (end + 1) % elements.length;
			amount += 1;

			notEmpty.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public T removeFrom() { // Assumes there is at least one element
		lock.lock();
		try {
			while (amount == 0) notEmpty.await();

			T item = (T) elements[begin];
			begin = (begin + 1) % elements.length;
			amount -= 1;

			notFull.signal();

			return item;
		} catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
			lock.unlock();
		}

		return null;
	}
}
