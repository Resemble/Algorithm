package Sixth;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * 数学原理
 * (a×b)%n = (a%n × b%n)%n
 * (a+b)%n = (a%n + b%n)%n
 * 示例: 求a^9%n
 * a^9%n = (a^8 × a)%n = (a^8%n × a%n)%n
 * a^8%n = (a^4 × a^4)%n = (a^4%n × a^4%n)%n
 * a^4%n = (a^2 × a^2)%n = (a^2%n × a^2%n)%n
 * a^2%n = (a × a)%n = (a%n × a%n)%n
 * a%n = (1 × a)%n = (1%n × a%n)%n = (a%n)%n
 *
 * @date 2017/9/20 10:09
 */
public class Qunaer3 {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        int b = sc.nextInt();
        BigInteger m = sc.nextBigInteger();
        System.out.println(a.pow(b).mod(m));
        System.out.println(mod(a.intValue(), b, m.intValue()));
        System.out.println(mod2(a.intValue(), b, m.intValue()));
    }

    static int mod(int a,int b,int m){
        int result = 1;
        int base = a;
        while(b>0){
            if((b & 1)==1){   // 奇数
                result = (result*base) % m;
            }
            base = (base*base) %m;
            b>>>=1;   // 二分
        }
        return result;
    }

    static int mod2(int a,int b,int m){
        int result = 1;
        for(int i=0;i<b;i++) {
            result = (result*a) %m;  // (a×b)%n = (a%n × b%n)%n
        }
        return result;
    }

}
