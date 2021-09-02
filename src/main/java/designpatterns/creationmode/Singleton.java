package designpatterns.creationmode;

/**
 * @author fxzou
 * @date 2021/9/2
 * @since IntelliJ IDEA
 */
public class Singleton {

    /**
     * 静态字段引用唯一的实例 提前初始化
     */
    private static final Singleton INSTANCE = new Singleton();


    /**
     * 保证外部无法访问
     */
    private Singleton() {
    }

    /**
     * 通过静态方法返回实例
     *
     * @return
     */
    public static Singleton getInstance() {
        return INSTANCE;
    }


}
