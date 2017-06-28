package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 给定一个整数数组，在该数组中，寻找三个数，
 * 分别代表三角形三条边的长度，问，可以寻找到多少组这样的三个数来组成三角形？
 * @date 2017/6/28 20:54
 */
public class TriangleCountSolution {

    public static void main(String[] args) {
        int s[] = new int[4];
        s[0] = 4;
        s[1] = 4;
        s[2] = 4;
        s[3] = 4;
//        s[4] = 1;
        TriangleCountSolution triangleCountSolution = new TriangleCountSolution();
        triangleCountSolution.triangleCount(s);
    }

    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        int count = 0;
        int size = S.length;
        int temp;
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size-1-i; j++) {
                if (S[j]>S[j+1]) {
                    temp = S[j];
                    S[j] = S[j+1];
                    S[j+1] = temp;
                }
            }
        }
        // 4 4 4 4
        // 3 4 6 7
        // 1 2 3 4 5 6 7 8 9 测试
        for (int i = size-1; i > 0; i--) {
            for (int j = 0; j < i-1; j++) {
                int k = j+1;
                while(k<i) {
                    if((S[j] + S[k]) > S[i]) {
                        count += (i-k);
                        break;
                    }
                    k++;
                }

            }

        }
        System.out.println("count:" + count);
        return count;
    }

}
