package BOJ.Intensify1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Score {
    static double caculate(String grade){
        if(grade.equals("A+"))return 4.5;
        else if(grade.equals("A0"))return 4.0;
        else if(grade.equals("B+"))return 3.5;
        else if(grade.equals("B0"))return 3.0;
        else if(grade.equals("C+"))return 2.5;
        else if(grade.equals("C0"))return 2.0;
        else if(grade.equals("D+"))return 1.5;
        else if(grade.equals("D0"))return 1.0;
        else return 0.0;
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Double>arr=new ArrayList<Double>(20);
        double gradeSum=0;
        double sum=0;
        double scoreSum=0;
        for(int i=0;i<20;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (grade.equals("P")) {
                continue;
            }
            scoreSum += score;
            double myGrade= caculate(grade);
            gradeSum+=myGrade*score;
        }
        System.out.println(gradeSum/scoreSum);
    }
}
