package designpatterns.creationmode;

/**
 * 这种方式称为 延迟初始化占位（Holder）类模式。
 * 该模式引进了一个静态内部类（占位类），
 * 在内部类中提前初始化实例，
 * 既保证了Singleton实例的延迟初始化，又保证了同步。
 * 这是一种提前初始化（恶汉式）和延迟初始化（懒汉式）的综合模式。
 *
 * @author fxzou
 * @date 2021/9/2
 * @since IntelliJ IDEA
 */
public class SingletonDelayHolder {

    private static class InstanceHolder {
        public static SingletonDelayHolder instance = new SingletonDelayHolder();
    }

    private SingletonDelayHolder() {

    }


    public static SingletonDelayHolder getInstance() {
        return InstanceHolder.instance;
    }
}
