package AlgorithmNote.NumberTheory;
import java.util.*;
public class Permutation {
    public static void permutation(int[] arr,int[] out,boolean[] visited, int depth, int r){
        if(depth==r){
            System.out.println(Arrays.toString(out));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                out[depth]=arr[i];
                permutation(arr,out,visited,depth+1,r);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args){
        int[] arr={1,2,3};
        int r=2;
        permutation(arr,new int[r],new boolean[arr.length],0,r);
    }
}
