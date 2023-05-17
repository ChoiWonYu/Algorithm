package BOJ.OneDimensionalArray;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class PutBall {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        StringBuilder sb=new StringBuilder();

        int[] numArray=new int[N];
        for(int i=0;i<M;i++){
            st=new StringTokenizer((br.readLine()));
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken());
            for( int j=s-1;j<e;j++)
                numArray[j]=num;
            }


        for(int num:numArray){
        sb.append(num).append(' ');
    }
        System.out.println(sb.toString());
        br.close();
    }
}
