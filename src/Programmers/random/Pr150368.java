package Programmers.random;

public class Pr150368 {

    static int N, M;
    static int[][] USERS;
    static int[] EMS, ANSWER, DC = new int[]{10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        USERS = users;
        EMS = emoticons;
        N = users.length;
        M = emoticons.length;
        ANSWER = new int[]{0, 0};
        matchDiscountRate(new EDiscount[M], 0);
        return ANSWER;
    }

    public void matchDiscountRate(EDiscount[] eDiscounts, int curIdx) {
        if (curIdx == M) {
            calculate(eDiscounts);
            return;
        }

        for (int i = 0; i < DC.length; i++) {
            eDiscounts[curIdx] = new EDiscount(curIdx, DC[i]);
            matchDiscountRate(eDiscounts, curIdx + 1);
        }
    }

    public void calculate(EDiscount[] eDiscounts) {
        int plusCnt = 0;
        int emsPrice = 0;
        for (int[] user : USERS) {
            int dcCondition = user[0];
            int plusCondition = user[1];
            int sum = 0;
            for (EDiscount ed : eDiscounts) {
                int price = EMS[ed.eIdx];
                int dcRate = ed.discountRate;
                if (dcRate < dcCondition) {
                    continue;
                }
                int dcPrice = price - price / 100 * dcRate;
                sum += dcPrice;
            }

            if (sum >= plusCondition) {
                plusCnt++;
            } else {
                emsPrice += sum;
            }
        }

        if (ANSWER[0] < plusCnt) {
            ANSWER[0] = plusCnt;
            ANSWER[1] = emsPrice;
        } else if (ANSWER[0] == plusCnt) {
            ANSWER[1] = Math.max(emsPrice, ANSWER[1]);
        }
    }
}

class EDiscount {

    int eIdx;
    int discountRate;

    public EDiscount(int eIdx, int discountRate) {
        this.eIdx = eIdx;
        this.discountRate = discountRate;
    }
}
