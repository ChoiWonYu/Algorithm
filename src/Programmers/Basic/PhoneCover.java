package Programmers.Basic;

public class PhoneCover {
    public String solution(String phone_number) {
        int length=phone_number.length();

        return "*".repeat(length-4)+phone_number.substring(length-4,length);
    }

    public static void main(String[] args) {

    }
}
