package AlgorithmNote.NumberTheory;

public class Permutation {
    public static void permutation(int[] arr,int[] out,boolean[] visited, int depth, int r){
        if(depth==r){
            for(int i:out)System.out.print(i);
            System.out.println();
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
        int[] arr={6,3,10};
        int r=3;
        permutation(arr,new int[arr.length],new boolean[arr.length],0,r);
    }
}
