package Programmers.Basic;

public class ReverseString {
    String res;
    public long solution(long n) {
        res="";
        String.valueOf(n).chars().sorted().forEach(c->res=String.valueOf((char)c)+res);

        return Long.parseLong(res);
    }

    public static void main(String[] args) {

    }
}
