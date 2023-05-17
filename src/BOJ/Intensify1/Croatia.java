package BOJ.Intensify1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Croatia {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();

        String[] arr= {"c=","c-","dz=","d-","lj","nj","s=","z="};
        int count=s.length();
        for(String l:arr){
            String copyS=s.trim();
            while(copyS.indexOf(l)!=-1){
                int idx=copyS.indexOf(l);
                copyS=copyS.substring(idx+l.length()-1);
                if(l=="dz="){
                    count+=1;
                }
                count-=l.length()-1;
            }
        }
        System.out.println(count);
    }
}
