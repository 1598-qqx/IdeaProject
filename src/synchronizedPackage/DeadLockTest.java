package synchronizedPackage;

/**
 * 线程同步和死锁的实现
 * 死锁必须满足占有并请求，而且线程之间请求的资源是闭环的
 * */

public class DeadLockTest {
    private final Object object1 = new Object();
    private final Object object2 = new Object();
    //静态方法只能调用静态方法，非静态方法可以调用静态和非静态方法。
    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();
        deadLockTest.logicalCode();
    }
    public void logicalCode(){
        Thread t1 = new Thread(()->{object1First();});
        Thread t2 = new Thread(()->{object2First();});
        t1.start();
        t2.start();
    }
    private  void object1First(){
        // 死锁需要满足占有并请求的条件
        synchronized(object1){
            System.out.println(Thread.currentThread().getName());
            sleep();
            synchronized(object2){
                sleep();
            }
            System.out.println("object1跳出");
        }

    }
    private void object2First(){
        //死锁，发生死锁的线程互相占有对方的资源
        synchronized(object2){
            System.out.println(Thread.currentThread().getName());
            sleep();
            synchronized(object1){
                sleep();
            }
            System.out.println("object2跳出");
        }
    }
    public static void sleep(){
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
