package AlgorithmNote.NumberTheory;
import java.util.*;

public class Combination {
    public static void combination(int[] arr,int[]output,boolean[] visited, int start,int n,int r){
        if(r==0){
            System.out.println(Arrays.toString(output));
            return;
        }
        for(int i=start;i<n;i++){
            visited[i]=true;
            output[r-1]=arr[i];
            combination(arr,output,visited,i+1,n,r-1);
            visited[i]=false;
        }
    }
    public static void main(String[] args){
        int[] nums=new int[]{1,2,3};
        int r=3;
        combination(nums,new int[r],new boolean[nums.length],0,nums.length,r);
    }
}
