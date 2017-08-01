package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 如何判断两个字符串是否由相同字符组成
 *               ASCII 码一共有256个
 * @date 2017/8/1 16:59
 */
public class CompareStringSolution {

    public static void compare(String s1, String s2) {
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();

        int[] bCount = new int[256];
        for (int i = 0; i < 256; i++) {
            bCount[i] = 0;
        }
        for (int i = 0; i < b1.length; i++) {
            bCount[b1[i]]++;
        }
        for (int i = 0; i < b2.length; i++) {
            bCount[b2[i]]--;
        }
        for (int i = 0; i < 256; i++) {
            if (bCount[i] != 0) {
                System.out.println("not equal!");
                return;
            }
        }
        System.out.println("equal!");
    }

    public static void main(String[] args) {
        String s1 = "123434rerfdsf##$$";
        String s2 = "124324rrfsdsf2323";
        compare(s1, s2);
        s1 = "aaassscd~s!";
        s2 = "aassssadc!~";
        compare(s1, s2);
    }

}
