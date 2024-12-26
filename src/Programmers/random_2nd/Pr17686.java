package Programmers.random_2nd;

import java.util.Arrays;
import java.util.Comparator;

public class Pr17686 {

    public String[] solution(String[] files) {
        Arrays.sort(files, new FileComparator());
        return files;
    }

    static class FileComparator implements Comparator<String> {

        @Override
        public int compare(final String o1, final String o2) {
            String f1 = o1.toLowerCase();
            String f2 = o2.toLowerCase();
            int p1 = 0;
            int p2 = 0;
            int strPoint1;
            int strPoint2;
            while (!Character.isDigit(f1.charAt(p1))) {
                p1++;
            }
            while (!Character.isDigit(f2.charAt(p2))) {
                p2++;
            }
            strPoint1 = p1;
            strPoint2 = p2;
            if (!f1.substring(0, p1).equals(f2.substring(0, p2))) {
                return f1.substring(0, p1).compareTo(f2.substring(0, p2));
            }

            while (p1 < f1.length() && Character.isDigit(f1.charAt(p1))) {
                p1++;
            }
            while (p2 < f2.length() && Character.isDigit(f2.charAt(p2))) {
                p2++;
            }
            int num1 = Integer.parseInt(f1.substring(strPoint1, p1));
            int num2 = Integer.parseInt(f2.substring(strPoint2, p2));
            return num1 - num2;
        }
    }
}
