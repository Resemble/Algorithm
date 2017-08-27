package Third;

import java.util.Scanner;

public class First360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int maxmn = Math.max(m, n);
        for (int r = 0; r <= maxmn; r++) {
            for (int s = 0; s <= maxmn; s++) {
                for (int p = 0; p <= maxmn; p++) {
                    if ((n >= (r*a + p * d)) && (m >= (r*b + s*c))) {
                        max = Math.max(max, (x*r + y*s + z*p));
                    }
                }
            }
        }
        System.out.println(max);
    }
}
