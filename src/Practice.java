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
        int[] arr=new int[] {1,2,3};
        int n=Arrays.stream(arr).min().getAsInt();
        int[] result=Arrays.stream(arr).filter(x->x!=n).toArray();
    }
}