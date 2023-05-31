package Programmers.BruteForce;
import java.util.*;

public class FindDecimal {
    public static boolean isDecimal(int n){
        if(n==1)return false;
        int count=0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0)count++;
        }
        return count==1;
    }

    static void getPermutation(Set<Integer> result,Character[] arr, Character[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            StringBuilder sb=new StringBuilder();
            for(Character s:output)if(s!=null)sb.append(s.toString());
            result.add(Integer.parseInt(sb.toString()));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                getPermutation(result,arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }


    public static int solution(String numbers) {
        int answer = 0;
        int n=numbers.length();
        Character[] arr=new Character[numbers.length()];
        for(int i=0;i<numbers.length();i++)arr[i]=numbers.charAt(i);

        Set<Integer> set=new HashSet<>();
        for(int i=1;i<=n;i++) {
            getPermutation(set,arr, new Character[n], new boolean[n], 0, n,i );
        }
        for(Integer s:set){
            boolean result=isDecimal(s);
            if(result)answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        String s="17";
        int result=solution(s);
        System.out.println(result);
    }
}
