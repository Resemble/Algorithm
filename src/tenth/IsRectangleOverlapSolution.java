package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-07-21 22:28
 */
public class IsRectangleOverlapSolution {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1 == null || rec2 == null) {
            return false;
        }
        if (rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec2[0] >= rec1[2] || rec2[1] >= rec1[3]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {1,0,2,1};
        IsRectangleOverlapSolution isRectangleOverlapSolution = new IsRectangleOverlapSolution();
        if (isRectangleOverlapSolution.isRectangleOverlap(rec1, rec2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


}
