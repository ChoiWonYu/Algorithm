package Programmers.array;

import java.util.*;

public class Gift {

    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;
        int[] result = new int[len];
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            m.put(friends[i], 0);
        }
        for (int i = 0; i < gifts.length; i++) {
            String[] input = gifts[i].split(" ");
            m.put(input[0], (m.get(input[0])) + 1);
            m.put(input[1], (m.get(input[1])) - 1);
        }

        for (int i = 0; i < len; i++) {
            String f1 = friends[i];
            for (int j = i + 1; j < len; j++) {
                String f2 = friends[j];
                int firstGift = compare(f1, f2, gifts);
                if (firstGift < 0) {
                    result[j]++;
                } else if (firstGift > 0) {
                    result[i]++;
                } else {
                    compareGiftNum(i, j, friends, m, result);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < result.length; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }

    public int compare(String f1, String f2, String[] gifts) {
        String input1 = f1 + " " + f2;
        String input2 = f2 + " " + f1;

        int result = 0;
        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i].equals(input1)) {
                result++;
            }
            if (gifts[i].equals(input2)) {
                result--;
            }
        }
        return result;
    }

    public void compareGiftNum(int f1, int f2, String[] friends, Map<String, Integer> m,
        int[] result) {
        int flag = m.get(friends[f1]) - m.get(friends[f2]);
        if (flag > 0) {
            result[f1]++;
        }
        if (flag < 0) {
            result[f2]++;
        }
    }

    ;
}
