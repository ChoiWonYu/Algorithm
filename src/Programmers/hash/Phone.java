package Programmers.hash;
import java.util.HashMap;

public class Phone {

}

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Boolean> arr=new HashMap<Integer,Boolean>();
        for(int i:nums){
            arr.put(i,true);
        }
        int N= nums.length;
        if(arr.size()<N/2)return arr.size();
        return N/2;
    }
}