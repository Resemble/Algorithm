package Forth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description:
 * @date 2017/9/5 21:20
 */
public class GoUpstairs {

    public int countWays(int n) {
        // write code here
        if (n==1) return 0;
        if (n==2) return 1;
        if (n==3) return 2;

        int[] count = new int[n];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        for (int i = 3; i < n; i++) {
            count[i] = (count[i-1] + count[i-2])%1000000007;;
        }
        return count[n-1];

    }


}
