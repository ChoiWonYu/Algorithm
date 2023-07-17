package inflearn.array;

import java.util.*;

public class Question {
    public static int solution(int[] nums){
        int plus=0;
        int score=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1) {
                plus += 1;
                score+=plus;
            }
            else plus=0;
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }

        int result = solution(nums);
        System.out.println(result);
    }
}
