package Programmers.dfsbfs;

public class TargetNumber {

    char[] cur, operator;
    int[] nums;
    int limit, targetNum, result = 0;

    public int solution(int[] numbers, int target) {
        int len = numbers.length;
        nums = numbers;
        targetNum = target;
        limit = len;
        operator = new char[]{'-', '+'};
        cur = new char[len];

        dfs(0);
        return result;
    }

    public void dfs(int depth) {
        if (depth == limit) {
            if (calculate(cur) == targetNum) {
                result++;
            }
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            cur[depth] = operator[i];
            dfs(depth + 1);
        }
    }

    public int calculate(char[] ops) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ops[i] == '+') {
                sum += nums[i];
            } else {
                sum -= nums[i];
            }
        }
        return sum;
    }

}
