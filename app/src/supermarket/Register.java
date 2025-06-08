package supermarket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Register {

	// Make sure that CONVEYOR_SIZE + BIN_SIZE >= Customer.MAX_ITEMS, otherwise
	// danger of deadlock
	private static final int CONVEYER_SIZE = 10, BIN_SIZE = 10;
	private ConveyorBelt<Item> belt = new ConveyorBelt<>(CONVEYER_SIZE);
	private ConveyorBelt<Item> bin = new ConveyorBelt<>(CONVEYER_SIZE);
	private Lock claimed = new ReentrantLock();

	public void putOnBelt(Item article) {
		belt.putIn(article);
	}

	public Item removeFromBelt() {
		return (Item) belt.removeFrom();
	}

	public void putInBin(Item article) {
		bin.putIn(article);
	}

	public Item removeFromBin() {
		return bin.removeFrom();
	}

	public void claim() {
		claimed.lock();
	}

	public void free() {
		claimed.unlock();
	}
}
