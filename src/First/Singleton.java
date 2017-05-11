package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 静态内部类
 * 登记式/静态内部类
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：一般
 * @date 2017/5/11 21:57
 */
public class Singleton {
   private static class SingletonHolder {
       private static final Singleton INSTANCE = new Singleton();
   }
   private Singleton(){}
   public static final Singleton getInstance() {
       return SingletonHolder.INSTANCE;
   }
}
