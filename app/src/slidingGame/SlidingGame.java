package slidingGame;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A sliding game
 */
public class SlidingGame implements Configuration {

	private int manhattanDist = 1337;
	public int dimensions = 3, size = dimensions * dimensions, hole = size;

	/**
	 * The board is represented by a 2-dimensional array; the position of the hole
	 * is kept in 2 variables holeX and holeY
	 */
	private int[][] board;
	private int holeX, holeY;
	private SlidingGame parent;

	/**
	 * A constructor that initializes the <code>board[X][Y]</code> with the specified array
	 *
	 * @param start A one dimensional array containing the initial board. The
	 *              elements of start are stored row-wise.
	 */
	public SlidingGame(int[] start) {
		this.board = new int[dimensions][dimensions];
		// I'm aware the this. aren't necessary, but we prefer to use it still for clarity.

		assert start.length == dimensions * dimensions : "Length of specified board incorrect";

		for (int p = 0; p < start.length; p++) {
			this.board[p % dimensions][p / dimensions] = start[p];
			if (start[p] == hole) {
				this.holeX = p % dimensions;
				this.holeY = p / dimensions;
			}
		}

		setManhattanDistance();
	}

	public SlidingGame(int[] start, int dimensions) {
		this(start);
		this.dimensions = dimensions;
		this.size = dimensions * dimensions;
		this.hole = this.size;
	}

	public SlidingGame(int[] start, SlidingGame parent) {
		this(start);
		this.parent = parent;
	}

	private void setManhattanDistance() {
		int manhattanDist = 0;
		for (int x = 0; x < this.dimensions; x++) {
			for (int y = 0; y < this.dimensions; y++) {
				int desiredX = this.board[x][y] % this.dimensions;
				int desiredY = this.board[x][y] / this.dimensions;

				manhattanDist += desiredX - x + desiredY - y;
			}
		}
		this.manhattanDist = manhattanDist;
	}

	public int getManhattanDistance() {
		return manhattanDist;
	}

	/**
	 * Converts a board into a printable representation. The hole is displayed as a
	 * space
	 *
	 * @return the string representation
	 */
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		for (int row = 0; row < dimensions; row++) {
			for (int col = 0; col < dimensions; col++) {
				int puzzle = board[col][row];
				buf.append(puzzle == hole ? "  " : puzzle + " ");
			}
			buf.append("\n");
		}
		return buf.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof SlidingGame game) {
			return game.board == this.board;
		}
		return false;
	}

	/**
	 * @return Whether the current configuration is solved.
	 */
	@Override
	public boolean isSolution() {
		for (int i = 0; i < size; i++) {
			int x = i % dimensions;
			int y = i / dimensions;

			if (this.board[x][y] != i) return false;
		}
		return true;
	}

	public static int[] toList(SlidingGame game) {
		int[] list = new int[game.size];

		for (int x = 0; x < game.dimensions; x++) {
			for (int y = 0; y < game.dimensions; y++) {
				list[x + y * game.dimensions] = game.board[x][y];
			}
		}

		return list;
	}

	@Override
	public Collection<Configuration> successors() {
		Collection<Configuration> successors = new ArrayList<>();

		for (Direction direction : Direction.values()) {
			int newHoleX = this.holeX + direction.getDX();
			int newHoleY = this.holeY + direction.getDY();

			if (newHoleX >= 0 && newHoleX < dimensions && newHoleY >= 0 && newHoleY < dimensions) {
				int[] list = toList(this);

				SlidingGame successor = new SlidingGame(list, this);

				// Move the piece in Direction
				successor.board[this.holeX][this.holeY] = this.board[newHoleX][newHoleY];
				successor.board[newHoleX][newHoleY] = this.size;

				successors.add(successor);
			}
		}
		return successors;
	}

	@Override
	public int compareTo(Configuration g) { // TODO implement this forked up function
		throw new UnsupportedOperationException("compareTo : not supported yet.");
	}

	@Override
	public Configuration getParent() {
		return this.parent;
	}

}
