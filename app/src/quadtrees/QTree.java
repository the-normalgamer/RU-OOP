package quadtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class QTree {
	private QuadTreeNode root;

	public QTree(Reader input) {
		root = readQTree(input);
	}

	public QTree(Bitmap bitmap) {
		root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
	}

	public void fillBitmap(Bitmap bitmap) {
		root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
	}

	public void writeQTree(Writer sb) {
		root.writeNode(sb);
	}

	private static QuadTreeNode readQTree(Reader input) {
		try {
			char data = (char) input.read();

			if (data == '1') {
				return new GreyNode(readQTree(input), readQTree(input), readQTree(input), readQTree(input));
			}

			return input.read() == '1' ? new WhiteLeaf() : new BlackLeaf();

		} catch (IOException e) {
			System.out.println("error:" + e);
		}

		// Base case
		return new BlackLeaf();
	}

	public static QuadTreeNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
		int halfWidth = width / 2;
		QuadTreeNode node;

		boolean color = bitmap.getBit(x, y);

		if (bitmap.areaSameColor(x, y, width)) {
			node = color ? new WhiteLeaf() : new BlackLeaf();
		} else {
			node = new GreyNode(
					bitmap2QTree(x,             y,             halfWidth, bitmap),
					bitmap2QTree(x + halfWidth, y,             halfWidth, bitmap),
					bitmap2QTree(x,             y + halfWidth, halfWidth, bitmap),
					bitmap2QTree(x + halfWidth, y + halfWidth, halfWidth, bitmap)
			);
		}

		return node;
	}

}
