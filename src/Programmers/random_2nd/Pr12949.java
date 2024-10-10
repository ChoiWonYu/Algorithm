package Programmers.random_2nd;

public class Pr12949 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        // arr1[0].length = arr2.length
        int len1 = arr1.length;
        int len2 = arr1[0].length;
        int len3 = arr2[0].length;

        int[][] result = new int[len1][len3];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len3; j++) {
                int sum = 0;
                for (int q = 0; q < len2; q++) {
                    sum += arr1[i][q] * arr2[q][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
