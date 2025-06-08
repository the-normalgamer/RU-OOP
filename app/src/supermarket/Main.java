package supermarket;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	private static final int NR_OF_CLIENTS = 100;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		Store store = new Store(executor);

		List<Future<Void>> cashiers = store.open();

		List<Customer> customers = IntStream.range(0, NR_OF_CLIENTS).mapToObj(i -> new Customer(i, store))
				.collect(Collectors.toList());
		List<Future<Integer>> customerResults = executor.invokeAll(customers);
		
		int totalItemsSold = 0;

		int totalItemsWanted = customers.stream().mapToInt(Customer::getNumberOfItemsWanted).sum();
		totalItemsSold = customerResults
			.stream()
			.map(Future -> {
				try {
					Future.get();
				} catch (InterruptedException | ExecutionException ignored) {}
				return 0;
			})
			.reduce(0, Integer::sum);

		cashiers.forEach(c -> {c.cancel(true); });
		executor.shutdown();
		try {
			executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("All customers are done.");
		System.out.println(totalItemsWanted + " items wanted.");
		System.out.println(totalItemsSold + " items sold.");
	}
}
