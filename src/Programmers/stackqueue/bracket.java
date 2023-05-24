package Programmers.stackqueue;
import java.util.*;

public class bracket {
    boolean solution(String s) {
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            st.push(s.charAt(i));
        }
        int count=0;
        while(!st.isEmpty()){
            Character p=st.pop();

            if(p=='('){
                if(count<=0)return false;
                count--;
            }
            else{
                count+=1;
            }
        }
        if(count!=0)return false;
        return true;
    }

    public static void main(String[] args){

    }
}
