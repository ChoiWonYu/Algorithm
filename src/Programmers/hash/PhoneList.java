package Programmers.hash;

import java.util.*;

class Solution3 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i]))return false;
        }
        return true;
    }
}

public class PhoneList {

    public static void main(String[] args){
        HashSet<String> s=new HashSet<String>();

        String[] arr={"12","1235","567","88","123"};

        Arrays.sort(arr);
    }
}
