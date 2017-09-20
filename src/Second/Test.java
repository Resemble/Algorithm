package Second;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:
 * @date 2017/7/8 10:48
 */
public class Test {

    public static void main(String[] args) {

        double d1 = 2.333000;
        double d2 = 2.3330;

        if (d1 == d2) {
            System.out.println("d1 == d2");
        } else {
            System.out.println("d1 != d2");
        }

        String d3 = "2.333000";
        String d4 = "2.3330";

        if (d3 == d4) {
            System.out.println("d3 == d4");
        } else {
            System.out.println("d3 != d4");
        }

        if (d3.equals(d4)) {
            System.out.println("d3.equals(d4)");
        } else {
            System.out.println("!d3.equals(d4)");
        }

        for (int i = 0; i < 200 && i < 150; i++) {
            System.out.println(i);
//            if (i>100) break;
        }

        int m = 2;
        int n = 10;
        System.out.println(++m*n++);
        double dou = 4.0;
        System.out.printf("%.4f", dou);

        int int1 = 1;
        int int0 = 0;
//        System.out.println(int1/int0);
        double double1 = 1.0;
        double double0 = 0.0;
//        System.out.println(double1/double0);
        System.out.println(int1/double0);

        if(int1 > double1) {
            System.out.println("大于");
        }else {
        }

    }

}
