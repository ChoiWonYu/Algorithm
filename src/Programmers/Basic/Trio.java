package Programmers.Basic;

public class Trio {
    public static int answer=0;
    public static void combination(int[] arr,boolean[] visited, int start,int n,int r){
        if(r==0){
            int sum=0;

            for(int i=0;i<n;i++){
                if(visited[i])sum+=arr[i];
            }

            System.out.println(sum);
            if(sum==0) {
                answer += 1;
            }

            return;
        }
        for(int i=start;i<n;i++){
            visited[i]=true;
            combination(arr,visited,i+1,n,r-1);
            visited[i]=false;
        }
    }

    public static int solution(int[] number) {
        boolean[] visited=new boolean[number.length];
        combination(number,visited,0,number.length,3);
        return answer;
    }

    public static void main(String[] args){
        int[] nums=new int[]{-2, 3, 0, 2, -5};
        int result=solution(nums);
        System.out.println(result);
    }

}
