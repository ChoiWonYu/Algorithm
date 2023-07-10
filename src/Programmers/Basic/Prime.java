package Programmers.Basic;

public class Prime {
    static int answer=0;

    public static boolean isPrime(int n){
        if(n==1)return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;
    }
    public static void Comb(int []nums,boolean[] visited,int start,int n,int r){
        if(r==0){
            int selected=0;
            for(int i=0;i<n;i++){
                if(visited[i])selected+=nums[i];
            }
            System.out.println(selected);
            if(isPrime(selected))answer++;
            return;
        }

        for(int i=start;i<n;i++){
            visited[i]=true;
            Comb(nums,visited,i+1,n,r-1);
            visited[i]=false;
        }
    }

    public static int solution(int[] nums) {
        int n=nums.length;
        boolean[] visited=new boolean[n];
        Comb(nums,visited,0,n,3);


        return answer;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};


        int result=solution(nums);
        System.out.println(result);
    }
}
