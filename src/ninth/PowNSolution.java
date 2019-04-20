package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019/4/13 11:12 PM
 */
public class PowNSolution {

    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        double temp;
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        } else if (n > 0) {
            temp = myPow(x, n / 2);
            if (n % 2 == 1) {
                return temp * temp * x;
            } else {
                return temp * temp;
            }
        } else {
            temp = myPow(x, n / 2);
            if (n % 2 == -1) {
                return temp * temp / x;
            } else {
                return temp * temp;
            }
        }
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = myPow2(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return  half * half / x;
        }
    }

    public double myPow3(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res = res * x;
            }
            /* 底数替换成 x 的平方 */
            x = x * x;
        }
        return n < 0 ? 1 / res : res;
    }


        public static void main(String[] args) {
        System.out.println(-4 / 2);
        System.out.println(-4 % 2);
        System.out.println(-5 % 2);
        PowNSolution powNSolution = new PowNSolution();
        double result = powNSolution.myPow(9.88023, 3);
        System.out.println(result);
    }
}
