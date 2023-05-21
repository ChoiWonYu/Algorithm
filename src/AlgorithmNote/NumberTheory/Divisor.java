package AlgorithmNote.NumberTheory;

import java.util.Collection;
import java.util.HashSet;

public class Divisor {
    static Collection getDivisor(int num){
        Collection<Integer> d=new HashSet<Integer>();

        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0){
                d.add(i);
                d.add(num/i);
            }
        }

        return d;
    }

    public static void main(String[] args){
        int num=6;
        Collection<Integer> result=getDivisor(num);

        result.toArray();
        for(int i:result){
            System.out.println(i);
        }
    }
}
