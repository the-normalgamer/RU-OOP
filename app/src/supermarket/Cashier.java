package supermarket;

import java.util.concurrent.Callable;

public class Cashier implements Callable<Void> {

	private final Register checkout;

	public Cashier(Register checkout) {
		this.checkout = checkout;
	}

	@Override
	public Void call() {

		while (!Thread.interrupted()) {
			checkout.putInBin(checkout.removeFromBelt());
		}
		return null;
	}
}
