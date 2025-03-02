package slidingGame;

import java.util.*;

/**
 * A class that implements a breadth-first search algorithm for finding the
 * Configurations for which the isSolution predicate holds
 */
public class Solver {
	// A queue for maintaining states that are not visited yet.
	private PriorityQueue<Configuration> toExamine;
	// A collection of states that have been visited
	private Collection<Configuration> encountered;

	public Solver(Configuration g) {
		toExamine = new PriorityQueue<Configuration>();
		toExamine.add(g);
	}

	/**
	 * A skeleton implementation of the solver
	 *
	 * @return a string representation of the solution
	 */
	public String solve() {
		while (!toExamine.isEmpty()) {
			Configuration next = toExamine.remove();
			if (encountered.contains(next)){
				continue;
			}
			encountered.add(next);
			if (next.isSolution()) {
				return next.toString();
			} else {
				for (Configuration succ : next.successors()) {
					toExamine.add(succ);
				}
			}
		}
		return "Failure!";
	}

}
