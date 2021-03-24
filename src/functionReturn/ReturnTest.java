package functionReturn;

public class ReturnTest {
    public static void main(String[] args) {
        System.out.println("测试try,finally返回值是否会被覆盖。");
        // 在finally语句块中增加返回语句会覆盖try语句块中的返回语句，因为finally语句块不管catch能否捕获异常
        // finally 语句块最终都会执行
        // 不管基本类型还是引用类型，finally代码块中的返回语句都会覆盖try语句块中的返回语句
        arrayPrint(tryTest());
    }
    public static int[] tryTest(){
        int[] result={1};
        try{
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            int[] b = {2};
            return b;
        }
    }
    public static void arrayPrint(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
    }
}
