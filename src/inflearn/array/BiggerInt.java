package inflearn.array;

import java.util.*;

public class BiggerInt {
    public static String solution(int n,int[] nums){
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        for(int i=1;i<n;i++) {
            if(nums[i]>nums[i-1])sb.append(" "+nums[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String result=solution(n,nums);
        System.out.println(result);
    }

}
