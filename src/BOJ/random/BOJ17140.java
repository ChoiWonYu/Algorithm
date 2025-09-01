package BOJ.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ17140 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        Map<Integer, Integer> map;
        List<List<Integer>> tmp;
        for (int i = 0; i <= 100; i++) {
            if (r - 1 < list.size() && c - 1 < list.get(0).size()
                && list.get(r - 1).get(c - 1) == k) {
                System.out.println(i);
                return;
            }
            int rLen = list.size();
            int cLen = list.get(0).size();

            if (cLen > rLen) {
                list = rotate(list);
            }
            tmp = new ArrayList<>();
            int maxLen = 0;
            for (int j = 0; j < list.size(); j++) {
                // map 초기화
                map = new HashMap<>();
                tmp.add(new ArrayList<>());
                for (int num : list.get(j)) {
                    if (num != 0) {
                        map.put(num, map.getOrDefault(num, 0) + 1);
                    }
                }

                // 숫자 : 개수 배열 생성
                List<int[]> cntList = new ArrayList<>();
                for (int n : map.keySet()) {
                    cntList.add(new int[]{n, map.get(n)});
                }

                // 숫자 : 개수 배열 정렬
                Collections.sort(cntList, (o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                });

                // 새로운 값 삽입
                for (int[] cnt : cntList) {
                    tmp.get(j).add(cnt[0]);
                    tmp.get(j).add(cnt[1]);
                }
                if (tmp.get(j).size() > 100) {
                    tmp.set(j, new ArrayList<>(tmp.get(j).subList(0, 100)));
                }
                maxLen = Math.max(maxLen, tmp.get(j).size());
            }
            // 0 패딩 채우기
            for (int j = 0; j < list.size(); j++) {
                int len = tmp.get(j).size();
                for (int z = 0; z < maxLen - len; z++) {
                    tmp.get(j).add(0);
                }
            }
            list = tmp;
            if (cLen > rLen) {
                list = rotate(list);
            }
        }

        System.out.println(-1);
    }

    public static List<List<Integer>> rotate(List<List<Integer>> list) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < list.get(0).size(); i++) {
            result.add(new ArrayList<>());
        }
        for (int i = 0; i < list.get(0).size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                result.get(i).add(list.get(j).get(i));
            }
        }
        return result;
    }
}
