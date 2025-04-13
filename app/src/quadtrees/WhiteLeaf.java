package quadtrees;

import java.io.IOException;
import java.io.Writer;

public class WhiteLeaf implements QuadTreeNode {
    /**
     * @param x
     * @param y
     * @param width
     * @param bitmap
     */
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {

    }

    /**
     * @param out
     */
    @Override
    public void writeNode(Writer out) {
        try {
            out.write("01");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
