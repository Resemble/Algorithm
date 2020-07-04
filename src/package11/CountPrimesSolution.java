package package11;

import java.util.Arrays;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 204. 计数质数
 * https://leetcode-cn.com/problems/count-primes/submissions/
 * @date 2020-07-04 15:40
 */
public class CountPrimesSolution {


    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }


    public int countPrimes2(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
