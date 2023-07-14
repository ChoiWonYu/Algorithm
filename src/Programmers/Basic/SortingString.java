package Programmers.Basic;

import java.util.Arrays;
import java.util.Comparator;

public class SortingString {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).map(s->new Word(s,s.charAt(n))).sorted()
                .map(w->w.word).toArray(String[]::new);

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

