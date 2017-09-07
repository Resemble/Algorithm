package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description:
 * @date 2017/9/7 20:41
 */
public interface TestInterface {

    void test2();


    default void testIn() {
        System.out.println("111111111");
    }

}
