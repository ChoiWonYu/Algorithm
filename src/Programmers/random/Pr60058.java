package Programmers.random;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Pr60058 {

    public String solution(String p) {
        return process(p);
    }

    public String process(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String[] seperated = seperate(s);
        String u = seperated[0];
        String v = seperated[1];
        if (isRightStr(u)) {
            return u + process(v);
        } else {
            String newV = '(' + process(v) + ')';
            u = u.substring(1, u.length() - 1);
            String newU = "";
            if (!u.isEmpty()) {
                for (char c : u.toCharArray()) {
                    if (c == '(') {
                        newU += ')';
                    } else {
                        newU += '(';
                    }
                }
            }
            return newV + newU;
        }
    }

    public String[] seperate(String s) {
        int rLen = 0;
        int lLen = 0;

        int idx = 0;
        while (idx < s.length() && ((rLen == 0 && lLen == 0) || rLen != lLen)) {
            if (s.charAt(idx) == '(') {
                rLen++;
            } else {
                lLen++;
            }
            idx++;
        }
        String[] arr = new String[2];
        arr[0] = s.substring(0, idx);
        if (idx == s.length()) {
            arr[1] = "";
        } else {
            arr[1] = s.substring(idx, s.length());
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public boolean isRightStr(String s) {
        Deque<Character> d = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                d.push(c);
            } else {
                if (d.isEmpty()) {
                    return false;
                }
                d.poll();
            }
        }
        return d.isEmpty();
    }
}
