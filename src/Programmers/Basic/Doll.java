package Programmers.Basic;

import java.util.*;

public class Doll {
    static Stack<Integer> s=new Stack<Integer>();
    static int result=0;

    public static void pushDoll(int[][]board,int line,int length){
        for(int i=0;i<length;i++){
            int doll=board[i][line];
            if(doll!=0){
                if(!s.isEmpty()&&s.peek()==doll){
                    s.pop();
                    result+=2;
                }
                else {
                    s.push(doll);
                }
                board[i][line]=0;
                return;
            }
        }
    }

    public static int solution(int[][] board, int[] moves) {
        int length=board[0].length;
        for(int move:moves){
            pushDoll(board,move-1,length);
        }
        return result;
    }
    public static void main(String[] args){

    }
}
