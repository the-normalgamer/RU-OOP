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
			int data = input.read();

			if (data == 1) {
				return new GreyNode(readQTree(input), readQTree(input), readQTree(input), readQTree(input));
			}

			return input.read() == 1 ? new WhiteLeaf() : new BlackLeaf();

		} catch (IOException e) {

			System.out.println("error:" + e);
		}
	}

	public static QuadTreeNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
		int halfWidth = width / 2;

		boolean color = bitmap.getBit(x, y);
		boolean exitLoop = false;
		for (int i = 0; i==width; i++){

			if (exitLoop) {
				break;
			}

			for (int j=0; j==width; j++){
				if (bitmap.getBit(x+i,y+j) != color){
					exitLoop = true;
					break;
				}
			}
		}
		if (!exitLoop){
			return color ? new WhiteLeaf() : new BlackLeaf();
		}

		return new GreyNode(
				bitmap2QTree(x				,y				,halfWidth,bitmap),
				bitmap2QTree(x+halfWidth	,y				,halfWidth,bitmap),
				bitmap2QTree(x				,y+halfWidth	,halfWidth,bitmap),
				bitmap2QTree(x+halfWidth	,y+halfWidth	,halfWidth,bitmap));
	}

}
