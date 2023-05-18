package BOJ.TwoDemensionalArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Column {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < arr[j].length()) sb.append(arr[j].charAt(i));
            }
        }
        System.out.println(sb.toString());

/*        char [][]arr=new char[5][15];
        int maxLength=0;
        for(int i=0;i<5;i++){
            String s=br.readLine();
            int length=s.length();
            if(length>maxLength)maxLength=length;
            int idx=0;
            while(idx<length){
                arr[i][idx]=s.charAt(idx++);
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<maxLength;i++){
            for(int j=0;j<5;j++){
                if((int)arr[j][i]!=0)sb.append(arr[j][i]);
            }
        }*/
/*
        System.out.println(sb.toString());
    }*/

    }
}
