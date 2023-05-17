package BOJ.Repeat;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Coding {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        num/=4;
        for(int i=0;i<num;i++){
            System.out.print("long ");
        }
        System.out.println("int");
    }
}
