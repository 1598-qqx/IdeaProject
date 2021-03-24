package sortpackage;

class MyThread extends Thread{
    @Override
    public void run() {
        //重写run方法，定义新线程的任务逻辑
        System.out.println("new Thread");
    }
}
interface funcInterface{
    //接口中的方法默认都是public访问权限
//    int add();
//    float add(float a);
    String add(String a, String b);
}
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread.sleep(1000);
        Thread.currentThread().interrupt();
        myThread.start();
        System.out.println(Thread.currentThread().getName()+Thread.currentThread().isInterrupted());
        System.out.println("main");
        System.out.println(Thread.currentThread().getName()+Thread.currentThread().isInterrupted());
        // lambda表达式是用来实现函数式接口的：函数式接口指的是，只含有一个抽象方法的接口
//        funcInterface fi = ()->44;
        //lambda表达式中的参数列表相当于实参
//        funcInterface fi = (float a)->a+1.0F;
        funcInterface fi = (String a, String b)->{
            String s = "sss";
            return s+"\t"+a+b;
        };
        System.out.println(fi.add("aa", "bb"));
    }
}
