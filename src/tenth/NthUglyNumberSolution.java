package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。
 *
 * 丑数是可以被 a 或 b 或 c 整除的 正整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 * 示例 2：
 *
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 12... 其中第 4 个是 6。
 * 示例 3：
 *
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 * 示例 4：
 *
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：在[0, k]内，能被数a整除的数的个数是k/a. 那么同时能被a、b整除的个数呢？答案是 k/a + k/b - k/(ab最小公倍数). 那么同时能被a、b、c整除的呢？
 * 答案是 k/a + k/b + k/c - k/(ab最小公倍数) - k/(ac最小公倍数) - k/(bc最小公倍数) + k/(abc最小公倍数).
 * 既然能求出能被a、b、c整除的个数，那么我们就可以使用二分进行求解，二分的目标就是所求答案，true条件为能被a、b、c整除的个数达到n个。
 *
 * 那么求a、b的最小公倍数怎么做？答案是用 a * b / ab最大公约数。
 * 那么求a、b、c的最小公倍数怎么做？答案是用 a * bc最小公倍数 / (a、bc最小公倍数 的最大公约数)。
 *
 * 作者：ekulelu
 * 链接：https://leetcode-cn.com/problems/ugly-number-iii/solution/c-er-fen-by-ekulelu-6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2020-03-26 21:50
 */
public class NthUglyNumberSolution {


    public int nthUglyNumber(int n, int a, int b, int c) {
        
        // 两两组合的最小公倍数
        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);

        // 三个数的最小公倍数
        long lcm = lcm(lcmAB, c);

        // lcm 之内的数字数目，即一个周期内的元素数
        long m = lcm / a + lcm / b + lcm / c - lcm / lcmAB - lcm / lcmAC -lcm / lcmBC + 1;
        long epoch = n / m;
        long r = n % m;
        long result = epoch * lcm;

        if (r > 0) {
            // 二分查找，范围缩小为 1~lcm
            long left = 1;
            long right = lcm;
            while (left < right) {
                long mid = left + (right - left) / 2;
                long count = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmAC - mid / lcmBC + mid / lcm;
                if (count >= r) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            result += left;
        }

        return (int) result;
    }

    // 最小公倍数
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // 最大公约数
    private long gcd(long x, long y) {
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }

    public static void main(String[] args) {
        int n = 3, a = 2, b = 3, c = 5;
//        1000000000
//        2
//        217983653
//        336916467
        NthUglyNumberSolution solution = new NthUglyNumberSolution();
        System.out.println(solution.nthUglyNumber(n, a, b, c));
    }

}
