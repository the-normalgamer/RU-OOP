package quadtrees;

import java.io.Writer;

public class GreyNode implements QuadTreeNode {
    private final QuadTreeNode topLeft;
    private final QuadTreeNode topRight;
    private final QuadTreeNode bottomLeft;
    private final QuadTreeNode bottomRight;

    public GreyNode(QuadTreeNode topLeft, QuadTreeNode topRight, QuadTreeNode bottomLeft, QuadTreeNode bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    /**
     * @param x
     * @param y
     * @param width
     * @param bitmap
     */
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        int halfWidth = width / 2;

        topLeft.fillBitmap    (x,             y,             halfWidth, bitmap);
        topRight.fillBitmap   (x + halfWidth, y,             halfWidth, bitmap);
        bottomLeft.fillBitmap (x,             y + halfWidth, halfWidth, bitmap);
        bottomRight.fillBitmap(x + halfWidth, y + halfWidth, halfWidth, bitmap);
    }

    /**
     * @param out
     */
    @Override
    public void writeNode(Writer out) {

    }
}
