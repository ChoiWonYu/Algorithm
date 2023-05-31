package Programmers.BruteForce;
import java.util.*;

public class MinRectangle {
    public int solution(int[][] sizes) {
        int xMaxSize=0;
        int yMaxSize=0;
        for(int[] arr:sizes){
            Arrays.sort(arr);
            if(xMaxSize<arr[0])xMaxSize=arr[0];
            if(yMaxSize<arr[1])yMaxSize=arr[1];
        }
        return xMaxSize*yMaxSize;
    }
}
