package BOJ.measureMultiplePrime;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Measure {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        TreeSet<Integer> s=new TreeSet<Integer>();

        for(int i=1;i<=Math.sqrt(N);i++){
            if(N%i==0){
                s.add(i);
                s.add(N/i);
            }
        }
        if(s.size()<K){
            System.out.println(0);
            return;
        }

        Iterator iter=s.iterator();
        int count=1;
        while(iter.hasNext()){
            if(count==K){
                System.out.println(iter.next());
                break;
            }
            iter.next();
            count++;
        }
    }

}
