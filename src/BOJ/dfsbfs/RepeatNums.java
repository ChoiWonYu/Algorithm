package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RepeatNums {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        String a = st.nextToken();
        int p = Integer.parseInt(st.nextToken());
        int cnt=0;
        String num=a;
        List<String> list=new ArrayList<>();
        Set<String> set = new HashSet<>();

        list.add(num);
        set.add(num);
        while(list.size()==set.size()){
            num=getSum(num,p);
            list.add(num);
            set.add(num);
        }

        for (String s : list) {
            if (s.equals(num)) break;
            cnt++;
        }

        System.out.println(cnt);
    }

    private static String getSum(String a, int p) {
        int sum=a.chars()
                .map(c->(int)Math.pow(Character.getNumericValue(c),p)).sum();
        return Integer.toString(sum);
    }
}
