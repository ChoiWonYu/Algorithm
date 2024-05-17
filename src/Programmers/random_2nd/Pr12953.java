package Programmers.random_2nd;

import java.util.*;

public class Pr12953 {

    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int curNum = arr[arr.length - 1];
        boolean flag = false;
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (curNum % arr[i] != 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            curNum++;
            flag = false;
        }
        return curNum;
    }
}
