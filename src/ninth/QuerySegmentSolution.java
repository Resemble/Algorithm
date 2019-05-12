package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-12 11:43
 */
public class QuerySegmentSolution {


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
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */

    private int segmentValue[];

    public int query2(SegmentTreeNode root, int start, int end) {
        // write your code here
        segmentValue = new int[root.end + 1];
        getSegmentValue(root);
        int maxValue = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            maxValue = Math.max(maxValue, segmentValue[i]);
        }
        return maxValue;
    }

    public void getSegmentValue(SegmentTreeNode root) {
        if (root.start == root.end) {
            segmentValue[root.start] = root.max;
        } else {
            getSegmentValue(root.left);
            getSegmentValue(root.right);
        }
    }


    /**
     * @title query2
     * @description 解法2
     * @param: root
     * @param: start
     * @param: end
     * @updateTime 2019-05-12 12:16
     * @return int
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root.start == start && root.end == end) {
            return root.max;
        }

        if (root.start == root.end) {
            return root.max;
        }

        int mid = (root.start + root.end) / 2;

        int maxValue = Integer.MIN_VALUE;
        if (end <= mid) {
            maxValue = Math.max(maxValue, query(root.left, start, end));
        } else if (start > mid) {
            maxValue = Math.max(maxValue, query(root.right, start, end));
        } else {
            maxValue = Math.max(maxValue, query(root.left, start, mid));
            maxValue = Math.max(maxValue, query(root.right, mid + 1, end));
        }
        return maxValue;
    }

}
