package Programmers.array;

import java.util.*;

class Data {

    public int code;
    public int date;
    public int max;
    public int remain;

    public Data(int code, int date, int max, int remain) {
        this.code = code;
        this.date = date;
        this.max = max;
        this.remain = remain;
    }

    public boolean ext(String ex, int val_ext) {
        switch (ex) {
            case "date":
                return date < val_ext;
            case "code":
                return code < val_ext;
            case "maximum":
                return max < val_ext;
            case "remain":
                return remain < val_ext;
        }
        return false;
    }

    public int[] toArr() {
        return new int[]{code, date, max, remain};
    }
}

public class DataAnal {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> l = new ArrayList<>();
        for (int[] d : data) {
            l.add(new Data(d[0], d[1], d[2], d[3]));
        }
        List<int[]> a = l.stream()
            .filter(d -> d.ext(ext, val_ext))
            .sorted((d1, d2) -> {
                switch (sort_by) {
                    case "code":
                        return d1.code - d2.code;
                    case "date":
                        return d1.date - d2.date;
                    case "maximum":
                        return d1.max - d2.max;
                    case "remain":
                        return d1.remain - d2.remain;
                }
                return 0;
            })
            .map(Data::toArr)
            .toList();

        int len = a.size();
        int[][] answer = new int[len][4];
        for (int i = 0; i < len; i++) {
            answer[i] = a.get(i);
        }

        return answer;
    }
}
