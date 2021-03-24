package sortpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ListSortTest {
    final static int CAPACITY = 10;
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i=0;
        while(i<ListSortTest.CAPACITY){
            intList.add(scanner.nextInt());
            i++;

        }
        System.out.println(intList.size());
        System.out.println("----------------------------");
        // 集合的sort方法是稳定的排序算法，自定义比较类必须实现Comparabel接口，实现自定义的compareTo方法
        Collections.sort(intList);
        //使用Collections类中的sort静态方法，对List集合对象进行排序,默认是升序，Comparator.reverseOrder()设置降序排序
//        Collections.sort(intList, Comparator.reverseOrder());
        //也可以使用实现了Comparator接口的类，实现对象的自定义排序

        //使用Collections.shuffle()对列表元素进行混排
//        Collections.shuffle(intList);
        for (Integer j:intList
             ) {
            System.out.println(j);

        }

    }
}
