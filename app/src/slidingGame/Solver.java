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
		encountered = new ArrayList<>();
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

			if (next.isSolution()) {
				String solution = "";
				for (Configuration config: next.pathFromRoot().reversed())
					solution += config.toString()+"n";
				return solution;
			} else {
                toExamine.addAll(next.successors());
			}
			encountered.add(next);
		}
		return "Failure!";
	}

}
