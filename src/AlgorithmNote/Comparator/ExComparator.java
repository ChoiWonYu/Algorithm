package AlgorithmNote.Comparator;
import java.util.*;

class Student implements Comparator<Student>{
    int age;
    Student(int a){
        this.age=a;
    }

    public int compare(Student a,Student b){
        return a.age-b.age;
    }
}

public class ExComparator {
    public static void main(String[]args){
        Student[] arr=new Student[10];
        for(int i=0;i<10;i++){
            arr[i]=new Student(i);
        };

        for(Student s:arr){
            System.out.println(s.age);
        }

        Arrays.sort(arr,Collections.reverseOrder(comp));

        for(Student s:arr){
            System.out.println(s.age);
        }
    }

    public static Comparator<Student> comp=new Comparator<Student>(){
        public int compare(Student s1,Student s2){
            return s1.age-s2.age;
        }
    };
}
