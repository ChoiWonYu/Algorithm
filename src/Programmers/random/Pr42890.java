package Programmers.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pr42890 {

    static final String SEPARATOR = " ";
    static String[][] RELATION;
    static Set<String> keys = new HashSet<>();
    static int cLen, rLen;

    public int solution(String[][] relation) {
        RELATION = relation;
        cLen = relation[0].length;
        rLen = relation.length;
        for (int i = 0; i < cLen; i++) {
            findKeys(new ArrayList<Integer>(List.of(i)));
        }
        Set<String> removeList = new HashSet<>();
        for (String key : keys) {
            for (String anotherKey : keys) {
                if (key.equals(anotherKey)
                    || key.length() > anotherKey.length()) {
                    continue;
                }
                if (containKeys(key.split(SEPARATOR), anotherKey)) {
                    removeList.add(anotherKey);
                }
            }
        }

        for (String rKey : removeList) {
            keys.remove(rKey);
        }

        return keys.size();
    }

    public boolean containKeys(String[] keys, String targetKey) {
        for (String k : keys) {
            if (!targetKey.contains(k)) {
                return false;
            }
        }
        return true;
    }

    public void findKeys(List<Integer> idxs) {
        String[] arr = new String[rLen];
        Arrays.fill(arr, "");
        for (int idx : idxs) {
            for (int i = 0; i < rLen; i++) {
                arr[i] += RELATION[i][idx] + SEPARATOR;
            }
        }
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            set.add(s);
        }
        if (set.size() == rLen) {
            String key = "";
            for (int idx : idxs) {
                key += idx + SEPARATOR;
            }
            keys.add(key);
        } else {
            int lastIdx = idxs.get((int) (idxs.size() - 1));
            for (int i = lastIdx + 1; i < cLen; i++) {
                idxs.add(i);
                findKeys(idxs);
                idxs.remove(Integer.valueOf(i));
            }
        }
    }
}
