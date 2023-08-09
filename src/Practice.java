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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=(int)reader.read();
        int m=(int)reader.read();
        System.out.println(n+" "+m);
    }
}