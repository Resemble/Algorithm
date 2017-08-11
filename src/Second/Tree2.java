package Second;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:有一棵二叉树，树上每个点标有权值，权值各不相同，
 * 请设计一个算法算出权值最大的叶节点到权值最小的叶节点的距离。二叉树每条边的距离为1，一个节点经过多少条边到达另一个节点为这两个节点之间的距离。
 * 去掉 static 是正确的
 * @date 2017/8/11 17:28
 */
public class Tree2 {

    private static int max = 0;
    private static int min = 99999;
    private static StringBuilder maxcodec;
    private static StringBuilder mincodec;

    static void preOrder(TreeNode node, char code, StringBuilder codec) {
        if (node != null) {
            codec.append(code);
            if (node.left == null && node.right == null) {
                if (max < node.val) {
                    max = node.val;
                    maxcodec = codec;
                }
                if (min > node.val) {
                    min = node.val;
                    mincodec = codec;
                }
            }
            preOrder(node.left, '0', new StringBuilder(codec));
            preOrder(node.right, '1', new StringBuilder(codec));
        }
    }

    public static int getDis(TreeNode root) {
        preOrder(root, '0', new StringBuilder());
        int index = 0;
        for (index = 0; index < (maxcodec.length() > mincodec.length() ? mincodec.length() : maxcodec.length()); index++) {
            if (maxcodec.charAt(index) != mincodec.charAt(index)) {
                break;
            }
        }
//        System.out.println("index:" + index);
//        System.out.println("maxcodec:" + maxcodec);
//        System.out.println("maxcodec.substring(index):" + maxcodec.substring(index));
//        System.out.println("mincodec:" + mincodec);
//        System.out.println("mincodec.substring(index):" + mincodec.substring(index));
        return (maxcodec.substring(index).length() + mincodec.substring(index).length());
    }

    public static void main(String[] args) {
        TreeNode node13 = new TreeNode(13);
        TreeNode node8 = new TreeNode(8);
        TreeNode node12 = new TreeNode(12);
        TreeNode node9 = new TreeNode(9);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node11 = new TreeNode(11);
        TreeNode node10 = new TreeNode(10);
        TreeNode node14 = new TreeNode(14);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node13.left = node8;
        node13.right = node12;
        node8.left = node9;
        node8.right = node6;
        node12.left = node4;
        node12.right = node3;
        node9.left = node7;
        node9.right = node11;
        node6.left = node10;
        node6.right = node14;
        node4.left = node2;
        node4.right = node5;
        node3.left = node1;


        System.out.println(getDis(node13));
    }

}
