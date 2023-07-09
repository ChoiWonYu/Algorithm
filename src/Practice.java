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
    public static void main(String[] args) {
        int n=9;
        System.out.println(Integer.toBinaryString(n));
        String x=Integer.toBinaryString(n);
        System.out.println("0".repeat(5-x.length())+x);
    }
}