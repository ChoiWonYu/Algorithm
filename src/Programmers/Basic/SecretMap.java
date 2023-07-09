package Programmers.Basic;

import java.util.*;

public class SecretMap {
    public static String getBinaryString(int n){
        return Integer.toBinaryString(n);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] sArr1=new String[n];
        String[] sArr2=new String[n];
        String[ ] answer=new String[n];
        for(int i=0;i<n;i++){
            String s1=getBinaryString(arr1[i]);
            String s2=getBinaryString(arr2[i]);

            sArr1[i]="0".repeat(n-s1.length())+s1;
            sArr2[i]="0".repeat(n-s2.length())+s2;

            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                if(sArr1[i].charAt(j)=='1'||sArr2[i].charAt(j)=='1')sb.append("#");
                else sb.append(" ");
            }
            answer[i]=sb.toString();
        }
        return answer;
    }

    public static void main(String[] args){
        int n=5;
     int[] arr1={9, 20, 28, 18, 11};
     int[] arr2={30, 1, 21, 17, 28};
     String[] result=solution(n,arr1,arr2);
     System.out.println(Arrays.toString(result));
    }
}
