package AlgorithmNote.NumberTheory;

public class Combination {
    public static void combination(int[] arr,boolean[] visited, int start,int n,int r){
        if(r==0){
            //visited에 선택됨
        }
        for(int i=start;i<n;i++){
            visited[i]=true;
            combination(arr,visited,start+1,n,r-1);
            visited[i]=false;
        }
    }
    public static void main(String[] args){

    }
}
