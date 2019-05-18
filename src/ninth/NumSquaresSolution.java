package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-18 14:52
 */
public class NumSquaresSolution {

    /**
     * @param n: a positive integer
     * @return: An integer
     */
    int[] tempSquare;
    public int numSquares(int n) {
        // write your code here
        tempSquare = new int[n];
        return getMinSquares(n);
    }

    public int getMinSquares(int n) {
        int sqrtNum = (int) Math.sqrt(n);
        if (n == sqrtNum * sqrtNum) {
            return 1;
        }
        int minNum = Integer.MAX_VALUE;
        int tempNum;
        int nextN;
        for (int i = sqrtNum; i >=1; i--) {
            nextN = n - i * i;
            if (tempSquare[nextN] != 0) {
                tempNum = tempSquare[nextN];
            } else {
                tempNum = getMinSquares(nextN);
                tempSquare[n - i * i] = tempNum;
            }
            minNum = Math.min(minNum, tempNum + 1);
        }
        return minNum;
    }

    public static void main(String[] args) {
        System.out.println(Math.floor(Math.sqrt(27)));
        System.out.println((int) Math.sqrt(27));
    }

}
