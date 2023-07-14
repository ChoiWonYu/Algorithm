package Programmers.Basic;

import java.util.Arrays;
import java.util.Comparator;

public class SortingString {
    public String[] solution(String[] strings, int n) {
        Word[] arr=new Word[strings.length];
        for(int i=0;i<strings.length;i++){
            arr[i]=new Word(strings[i],strings[i].charAt(n));
        }
        Arrays.sort(arr);
        String[] answer=new String[strings.length];
        for(int i=0;i<strings.length;i++){
            answer[i]=arr[i].word;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}

class Word implements Comparable<Word> {

    public String word;
    public Character keyWord;

    Word(String w,Character c){
        word=w;
        keyWord=c;
    }

    @Override
    public int compareTo(Word o) {
        if(this.keyWord.compareTo(o.keyWord)==0)return this.word.compareTo(o.word);
        return this.keyWord.compareTo(o.keyWord);
    }
}

