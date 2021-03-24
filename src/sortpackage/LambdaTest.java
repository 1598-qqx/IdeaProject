package sortpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class LambdaTest {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(12);
        al.add(0);
        al.add(34);
        //如果需要自定义排序规则，需要定义实现了Comparator接口的类对象作为参数，或者用lambda表达式指定compareTo方法的实现逻辑
        Collections.sort(al,(Integer a, Integer b)->a-b);
        Iterator<Integer> iterator = al.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
