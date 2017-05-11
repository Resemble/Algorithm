package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description:
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * 实现难度：易
 * 描述：这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。
 * 它更简洁，自动支持序列化机制，绝对防止多次实例化
 * @date 2017/5/11 22:11
 */
public enum Singleton2 {
    INSTANCE;
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
