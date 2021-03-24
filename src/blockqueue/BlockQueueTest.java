package blockqueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class BlockQueueTest {
    private static final int FILE_SIZE = 10;
    private static final int SEARCH_THREADS =100;
    private static final File DUMMY = new File("");
    private static final BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_SIZE);

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            System.out.print("enter base file path(eg. jdk/jre/src):");
            /*
            * next()和nextLine()的区别：next()从输入的第一个非空格和回车字符起
            * 到碰到下一个回车或空格止，读入其中所有字符作为字符串
            *
            * nextLine()扫描剩下的所有字符，直到遇到回车符为止
            *
            * 简单的说就是：next()遇到空格和回车都会停止扫描
            * nextLine()只有遇到回车才会停止扫描
            * */
            String directory = in.nextLine();
            System.out.println("enter key words(eg volatile)");
            String keyWord = in.nextLine();
            Runnable r1 = ()->{
                try{
                    enumerate(new File(directory));
                    queue.put(DUMMY);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            };
            new Thread(r1).start();
            for(int i=1;i<=SEARCH_THREADS;i++){
                Runnable r2 = ()->{
                    try{
                        boolean done = false;
                        while(!done){
                            File file = queue.take();
                            if(file==DUMMY){
                                queue.put(file);
                                done=true;
                            }
                            else{
                                search(file, keyWord);
                            }
                        }
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    catch(InterruptedException e){

                    }

                };
                new Thread(r2).start();
            }
        }
    }
    public static void enumerate(File directory) throws InterruptedException{
        File[] files = directory.listFiles();
        for(File file:files){
            if(file.isDirectory())
                enumerate(file);
            else
                // put向队列中添加元素，若队满则被阻塞
                queue.put(file);
        }
    }
    public static void search(File file, String keyWord) throws IOException{
        try(Scanner in = new Scanner(file,"UTF-8")){
            int lineNumber = 0;
            while(in.hasNext()){
                lineNumber++;
                String line = in.nextLine();
                if(line.contains(keyWord)){
                    System.out.printf("%s:%d:%s/n",file.getPath(),lineNumber,line);
                }
            }
        }
    }
}
