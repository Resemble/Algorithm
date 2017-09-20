package Sixth;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2017/9/20 10:09
 */
public class Qunaer3 {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        int b = sc.nextInt();
        BigInteger m = sc.nextBigInteger();
        System.out.println(a.pow(b).mod(m));
    }

}
