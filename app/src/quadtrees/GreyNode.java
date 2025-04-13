package quadtrees;

import java.io.IOException;
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

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        int halfWidth = width / 2;

        topLeft.fillBitmap    (x,             y,             halfWidth, bitmap);
        topRight.fillBitmap   (x + halfWidth, y,             halfWidth, bitmap);
        bottomLeft.fillBitmap (x,             y + halfWidth, halfWidth, bitmap);
        bottomRight.fillBitmap(x + halfWidth, y + halfWidth, halfWidth, bitmap);
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write("1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        topLeft.writeNode(out);
        topRight.writeNode(out);
        bottomLeft.writeNode(out);
        bottomRight.writeNode(out);
    }
}
