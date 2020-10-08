package package12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description:
 * @date 2020-10-08 17:06
 */
public class BinaryTreePathsSolution {

    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePathsHelper(root, "");
        return result;
    }

    public void binaryTreePathsHelper(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        path = path + "->" + root.val;
        if (root.left == null && root.right == null) {
            result.add(path.substring(2));
            return;
        }
        binaryTreePathsHelper(root.left, path);
        binaryTreePathsHelper(root.right, path);
    }

}
