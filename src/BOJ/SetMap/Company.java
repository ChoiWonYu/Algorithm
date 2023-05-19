package BOJ.SetMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Company {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        HashMap P=new HashMap();

        for(int i=0;i<T;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String name=st.nextToken();
            String action=st.nextToken();
            if(action.equals("enter")){
                P.put(name,action);
            }
            else if(action.equals("leave")){
                P.remove(name);
            }
            else continue;
        }

    }
}
