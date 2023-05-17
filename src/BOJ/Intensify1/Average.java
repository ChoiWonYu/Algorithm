package BOJ.Intensify1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Average {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            StringBuilder sb=new StringBuilder();
            int num=Integer.parseInt(st.nextToken());
            int sum=0;
            int[] scores=new int[num];
            for(int j=0;j<num;j++){
                int s=Integer.parseInt(st.nextToken());
                scores[j]=s;
                sum+=s;
            }
            double average=sum/num;
            int students=0;
            for(int n:scores){
                if(n>average)students++;
            }
            sb.append(String.format("%.3f",(double)students/num*100)).append('%');
            System.out.println(sb.toString());
        }
    }
}
