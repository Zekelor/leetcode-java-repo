package designpatterns.creationmode;

/**
 *
 * 这样一种设计可以保证只产生一个实例，并且只会在初始化的时候加同步锁，看似精妙绝伦，但却会引发另一个问题，这个问题由 指令重排序引起。
 * 指令重排序是为了优化指令，提高程序运行效率。指令重排序包括编译器重排序和运行时重排序。JVM规范规定，指令重排序可以在不影响单线程程序执行结果前提下进行。
 * 例如 instance = new Singleton() 可分解为如下伪代码：
 * <code>
 *     memory = allocate();     //1. 分配对象的内存空间
 *     ctorInstance(memory);    //2. 初始化对象
 *     instance = memory;       //3. 设置instance指向刚分配的对象
 * </code>
 *
 * 但是指令重排可能会导致下述情况
 * <code>
 *      memory = allocate();     //1. 分配对象的内存空间
 *      instance = memory;       //3. 设置instance指向刚分配的对象
 *                               // Warning ： 此时对象还没有初始化
 *      ctorInstance(memory);    //2. 初始化对象
 * </code>
 *
 * 将第2步和第3步调换顺序，在单线程情况下不会影响程序执行的结果，但是在多线程情况下就不一样了。
 * 线程A执行了instance = memory（这对另一个线程B来说是可见的），
 * 此时线程B执行外层 if (instance == null)，发现instance不为空，随即返回，但是 得到的却是未被完全初始化的实例，在使用的时候必定会有风险，这正是双重检查锁定的问题所在！
 *
 * 因此若使用DCL 需要搭配volatile禁止变量进行内部排序
 *
 * @author fxzou
 * @date 2021/9/2
 * @since IntelliJ IDEA
 */
public class SingletonDCL {
    private static volatile SingletonDCL INSTANCE;

    private SingletonDCL() {

    }

    /**
     * 双重检查加锁
     *
     * @return
     */
    public static SingletonDCL getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDCL();
                }
            }
        }
        return INSTANCE;
    }
}
