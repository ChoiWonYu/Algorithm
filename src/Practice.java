import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Calculator{
    final int x;
    Calculator (){
        x=1;
    }
}
public class Practice {
    public static void main(String[] args)throws Exception {
        Set<Integer>s1=new HashSet<>();
        Set<Integer>s2=new HashSet<>();

        int[]arr=new int[4];

        for(int i=1;i<=4;i++)arr[i-1]=i;


        s1.add(1);
        s1.add(2);
        s1.add(3);

        s2.add(4);

        s1.remove(4);
        System.out.println(s1);
    }
}