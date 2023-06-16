package Programmers.Basic;

public class Password {
    public static boolean isInArr(char targetCh,int[] skipArr){
        for(int i :skipArr){
            if(i==targetCh)return true;
        }
        return false;
    }
    public static int[] getSkipArr(String skip){
        int []arr=new int[skip.length()];
        for(int i=0;i<skip.length();i++){
            arr[i]=skip.charAt(i);
        }
        return arr;
    }

    public static char plusChar(char target){
        if(target=='z')return 'a';
        return (char)(target + 1);
    }


    public static String solution(String s, String skip, int index) {
        int[] skipArr=getSkipArr(skip);

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char targetChar=s.charAt(i);
            for(int j=0;j<index;j++){
                targetChar=plusChar(targetChar);
                while(isInArr(targetChar,skipArr))targetChar=plusChar(targetChar);
            }
            sb.append(Character.toString(targetChar));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s="ybc";
        String skip="az";
        int index=1;
        String ans=solution(s,skip,index);
        System.out.println(ans);
    }
}
