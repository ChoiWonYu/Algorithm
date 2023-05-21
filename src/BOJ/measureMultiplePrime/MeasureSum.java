package BOJ.measureMultiplePrime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class MeasureSum {
    static TreeSet<Integer> getMeasure(int num){
        TreeSet<Integer> result=new TreeSet<Integer >();
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0) {
                result.add(i);
                if(i!=1)result.add(num/i);
            }
        }
        return result;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=0;
        while(true){
            StringBuilder sb=new StringBuilder();
            num=Integer.parseInt(br.readLine());

            sb.append(num).append(' ').append('=').append(' ');

            if(num==-1)break;
            TreeSet<Integer> result=getMeasure(num);
            Iterator iter=result.iterator();
            int sum=0;
            while(iter.hasNext()){
                int number=(int)iter.next();
                sum+=number;
                sb.append(number);
                if(iter.hasNext())sb.append(' ').append('+').append(' ');
            }

            if(sum==num){
                System.out.println(sb.toString());
            }
            else{
                System.out.print(num);
                System.out.println(" is NOT perfect.");
            }
        }

    }
}
