package supermarket;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class Customer implements Callable<Integer> {

	public static final int MAX_ITEMS = 20;
	private final Store store;
	private final int customerNumber;
	private final int numberOfItemsWanted;
	private final static Random GENERATOR = new Random();
	
	public int getNumberOfItemsWanted() {
		return numberOfItemsWanted;
	}

	public Customer(int number, Store store) {
		this.store = store;
		customerNumber = number;
		numberOfItemsWanted = GENERATOR.nextInt(MAX_ITEMS) + 1;
	}

	@Override
	public Integer call() {
		int numberOfItemsBought = 0;
		Register register = store.claimRegister(GENERATOR.nextInt(Store.NUMBER_OF_CHECKOUTS));
		register.claim();
		Stream<Item> items = store.getItems(numberOfItemsWanted).stream();
		items.forEach(register::putOnBelt);
		register.putOnBelt(null);
		while (numberOfItemsWanted > 0 && numberOfItemsBought < numberOfItemsWanted) {
			register.removeFromBin(); //not sure how quick the items go to the bin so idk if this works.
			numberOfItemsBought++;
		}
		register.free();
		return numberOfItemsBought;
	}
}
