package Programmers.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pr258709 {

    static int N;
    static int[][] dice;
    static int maxWins = -1;
    static int[] answer;

    public int[] solution(int[][] dice) {
        this.dice = dice;
        N = dice.length;
        answer = new int[N / 2];

        // 1. A가 가질 주사위 조합 구하기
        int[] combination = new int[N / 2];
        generateDiceCombinations(0, 0, combination);

        return answer;
    }

    // A가 가질 N/2개의 주사위 조합을 구하는 함수
    private void generateDiceCombinations(int index, int start, int[] combination) {
        if (index == N / 2) {
            calculateWinsForCombination(combination);
            return;
        }

        for (int i = start; i < N; i++) {
            combination[index] = i;
            generateDiceCombinations(index + 1, i + 1, combination);
        }
    }

    // 한 조합에 대해 승리 횟수를 계산하는 함수
    private void calculateWinsForCombination(int[] combinationA) {
        List<Integer> sumsA = new ArrayList<>();
        List<Integer> sumsB = new ArrayList<>();

        // B가 가질 주사위 조합 구하기
        int[] combinationB = new int[N / 2];
        boolean[] isA = new boolean[N];
        for (int idx : combinationA) {
            isA[idx] = true;
        }
        int bIdx = 0;
        for (int i = 0; i < N; i++) {
            if (!isA[i]) {
                combinationB[bIdx++] = i;
            }
        }

        // 2. 각 조합의 모든 점수 합 구하기
        generateSums(0, 0, combinationA, sumsA);
        generateSums(0, 0, combinationB, sumsB);

        // 3. B의 점수 합 정렬
        Collections.sort(sumsB);

        // 4. 이진 탐색으로 A의 승리 횟수 계산
        int wins = 0;
        for (int sumA : sumsA) {
            wins += binarySearch(sumsB, sumA);
        }

        // 5. 최대 승리 횟수 갱신
        if (wins > maxWins) {
            maxWins = wins;
            for (int i = 0; i < N / 2; i++) {
                answer[i] = combinationA[i] + 1;
            }
        }
    }

    // 재귀적으로 모든 점수 합을 구하는 함수
    private void generateSums(int depth, int currentSum, int[] combination,
        List<Integer> sums) {
        if (depth == N / 2) {
            sums.add(currentSum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            generateSums(depth + 1, currentSum + dice[combination[depth]][i], combination,
                sums);
        }
    }

    // target보다 작은 숫자의 개수를 이진 탐색으로 찾는 함수 (lower bound)
    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
