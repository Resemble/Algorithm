package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-12 11:03
 */





public class BuildSegmentTree {

    public class SegmentTreeNode {
        public int start, end;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }

    /*
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if (start > end) return null;
        SegmentTreeNode rootTreeNode = new SegmentTreeNode(start, end);
        if (start == end) return rootTreeNode;
        rootTreeNode.left = build(start, (start + end) / 2);
        rootTreeNode.right = build((start + end) / 2 + 1, end);
        return rootTreeNode;
    }
}
