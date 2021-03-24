package sortpackage;

import java.util.Scanner;

public class FirstSort {
    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while(i<a.length){
            a[i] = scanner.nextInt();
            i++;
        }
        for(int j=0;j<a.length;j++){
            System.out.println(a[j]);
        }
        int max = a[0];
        //寻找数组中的最大值
        for(int k=1;k<a.length;k++){
            if(max<a[k]){
                max = a[k];
            }
        }
        System.out.println(max);

    }
}
