package Programmers.BruteForce;

public class Test {
    public static int[] solution(int[] answers) {
        int[] count=new int[3];
        for(int i=0;i<answers.length;i++){
            if(answers[i]==(i%5)+1)count[0]++;
            switch(i%8){
                case 0:
                case 2:
                case 4:
                case 6:
                    if(answers[i]==2)count[1]++;
                    break;
                case 1:
                    if(answers[i]==1)count[1]++;
                    break;
                case 3:
                    if(answers[i]==3)count[1]++;
                    break;
                case 5:
                    if(answers[i]==4)count[1]++;
                    break;
                case 7:
                    if(answers[i]==5)count[1]++;
                    break;
            }

                switch(i%10){
                    case 0:
                    case 1:
                        if(answers[i]==3)count[2]++;
                        break;
                    case 2:
                    case 3:
                        if(answers[i]==1)count[2]++;
                        break;
                    case 4:
                    case 5:
                        if(answers[i]==2)count[2]++;
                        break;
                    case 6:
                    case 7:
                        if(answers[i]==4)count[2]++;
                        break;
                    default:
                        if(answers[i]==5)count[2]++;
                }
        }
        int max=0;
        int maxCount=0;
        for(int i:count){
            if(max<i) {
                max = i;
                maxCount=1;
            }
            else if(max==i)maxCount++;
        }
        int[] answer=new int[maxCount];
        int idx=0;
        for(int i=0;i<3;i++){
            if(count[i]==max)answer[idx++]=i+1;
        }
        return answer;
    }

    public static void main(String[] args){
        int[] answers={1,3,2,4,2};
        int[] result=solution(answers);
        for(int i:result){
            System.out.print(i);
        }
    }
}
