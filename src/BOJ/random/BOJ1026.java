package BOJ.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr1.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            arr2.add(sc.nextInt());
        }
        Collections.sort(arr1);
        Collections.sort(arr2, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            answer += arr1.get(i) * arr2.get(i);
        }
        System.out.println(answer);
    }
}
