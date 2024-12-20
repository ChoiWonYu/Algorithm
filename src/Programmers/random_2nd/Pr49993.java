package Programmers.random_2nd;

import java.util.Arrays;

public class Pr49993 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] tree = new int[26];
        for (String st : skill_trees) {
            init(tree, skill);
            if (isValid(tree, st)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isValid(int[] tree, String st) {
        int order = 1;
        for (char cur : st.toCharArray()) {
            if (tree[(int) (cur - 'A')] == 0) {
                continue;
            }
            if (tree[(int) (cur - 'A')] == order) {
                order++;
                continue;
            }
            return false;
        }
        return true;
    }

    public void init(int[] tree, String skill) {
        Arrays.fill(tree, 0);
        int order = 1;
        for (char cur : skill.toCharArray()) {
            tree[(int) (cur - 'A')] = order++;
        }
    }
}
