package Programmers.Basic;

public class CaesarCipher {
    public static boolean isUpperCase(int c){
        return c<=90&&c>=65?true:false;
    }

    public static String solution(String s, int n) {
        StringBuilder sb=new StringBuilder();
        s.chars().map(ch->{
                    if(isUpperCase(ch))return ((ch-'A'+n)%26+'A');
                    else if(ch==' ') return ' ';
                    else return ((ch-'a'+n)%26+'a');
                })
                .forEach(ch->sb.append((char)ch));
        return sb.toString();
    }

    public static void main(String[] args) {
        String result=solution("a B z",4);
        System.out.println(result);
    }
}
