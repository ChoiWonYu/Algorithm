package BOJ.SetMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SawHeard {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> S=new TreeSet<String>();
        TreeSet<String> H=new TreeSet<String>();

        StringTokenizer st=new StringTokenizer(br.readLine());
        int sNum=Integer.parseInt(st.nextToken());
        int hNum=Integer.parseInt(st.nextToken());

        for(int i=0;i<sNum;i++){
            S.add(br.readLine());
        }

        for(int i=0;i<hNum;i++){
            H.add(br.readLine());
        }

        Iterator<String> iter=S.iterator();
        StringBuilder sb=new StringBuilder();
        int count=0;

        while(iter.hasNext()){
            String t=iter.next();
            if(H.contains(t)){
                count++;
                sb.append(t).append('\n');
            }
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
