package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package ChapterTwo.Two_1
 * @Description:
 * @date 2017/5/7 21:50
 */
public class Test {
    public static void main(String args[]) {
        Singleton singletonA = Singleton.getInstance();
        Singleton singletonB = Singleton.getInstance();
        System.out.println(singletonA.equals(singletonB));

        Singleton2 singleton2A = Singleton2.INSTANCE;
        Singleton2 singleton2B = Singleton2.INSTANCE;
        System.out.println(singleton2A.equals(singleton2B));

        System.out.println("Test");
    }
}
