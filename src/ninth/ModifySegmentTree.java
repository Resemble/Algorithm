package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-12 21:24
 */
public class ModifySegmentTree {


    public class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }

    /**
     * @param root:  The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: nothing
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root.start == root.end) {
            if (root.start == index) {
                root.max = value;
            }
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index > mid) {
            modify(root.right, index, value);
        } else {
            modify(root.left, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
    }
}
