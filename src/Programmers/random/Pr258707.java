package Programmers.random;

import java.util.HashSet;
import java.util.Set;

public class Pr258707 {

    public static void main(String[] args) {
        Pr258707 pr258707 = new Pr258707();
        pr258707.solution(4, new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4});
    }

    public int solution(int coin, int[] cards) {
        int n = cards.length;

        // 1. 자료구조 초기화
        Set<Integer> hand = new HashSet<>();
        Set<Integer> pool = new HashSet<>();

        // 2. 초기 카드 분배
        for (int i = 0; i < n / 3; i++) {
            hand.add(cards[i]);
        }

        int round = 1;
        int cardIndex = n / 3;

        // 3. 라운드 진행
        while (cardIndex < n) {
            // 카드 2장 뽑아서 pool에 추가
            pool.add(cards[cardIndex++]);
            pool.add(cards[cardIndex++]);

            boolean roundPassed = false;

            // 우선순위 1: hand 카드 2장 사용 (코인 0개)
            for (int cardInHand : hand) {
                if (hand.contains(n + 1 - cardInHand)) {
                    hand.remove(cardInHand);
                    hand.remove(n + 1 - cardInHand);
                    roundPassed = true;
                    break;
                }
            }
            if (roundPassed) {
                round++;
                continue;
            }

            // 우선순위 2: hand 1장 + pool 1장 사용 (코인 1개)
            if (coin >= 1) {
                for (int cardInHand : hand) {
                    if (pool.contains(n + 1 - cardInHand)) {
                        coin--;
                        hand.remove(cardInHand);
                        pool.remove(n + 1 - cardInHand);
                        roundPassed = true;
                        break;
                    }
                }
            }
            if (roundPassed) {
                round++;
                continue;
            }

            // 우선순위 3: pool 카드 2장 사용 (코인 2개)
            if (coin >= 2) {
                for (int cardInPool : pool) {
                    if (pool.contains(n + 1 - cardInPool)) {
                        coin -= 2;
                        pool.remove(cardInPool);
                        pool.remove(n + 1 - cardInPool);
                        roundPassed = true;
                        break;
                    }
                }
            }

            if (roundPassed) {
                round++;
            } else {
                // 어떤 조합으로도 카드를 낼 수 없으면 게임 종료
                break;
            }
        }

        return round;
    }
}
