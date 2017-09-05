package Forth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description:
 * @date 2017/9/5 20:49
 */
public class Balls {

    public static void main(String[] args) {
        int A = 100;
        int B = 90;
        int C = 80;
        int D = 70;
        System.out.println(getSum(A));
        System.out.println(getSum(B));
        System.out.println(getSum(C));
        System.out.println(getSum(D));
    }

    public int calcDistance(int A, int B, int C, int D) {
        // write code here
        return (int) (getSum((double) A) + getSum((double)B) + getSum((double)C) + getSum((double)D));
    }
    public static double getSum (double h) {
        double sum = h;
        while(h>0.01) {
            h = h / 2;
            sum += h * 2;
        }
        return sum;
    }
}
