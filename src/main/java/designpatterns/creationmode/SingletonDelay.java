package designpatterns.creationmode;

/**
 * @author fxzou
 * @date 2021/9/2
 * @since IntelliJ IDEA
 */
public class SingletonDelay {

    private static SingletonDelay INSTANCE;


    private SingletonDelay() {
    }

    /**
     * 延迟初始化方式，为了多线程可用，需加同步锁
     *
     * @return
     */
    public static synchronized SingletonDelay getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new SingletonDelay();
        }

        return INSTANCE;
    }
}
