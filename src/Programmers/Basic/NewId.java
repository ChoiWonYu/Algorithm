package Programmers.Basic;

public class NewId {
    public static String solution(String new_id) {
        String answer=new_id.toLowerCase();
        answer=answer.replaceAll("[^a-z0-9._-]","");
        while(answer!=answer.replace("..","."))answer=answer.replace("..",".");
        answer=answer.charAt(0)=='.'?answer.substring(1):answer;
        answer=answer.length()>0&&answer.charAt(answer.length()-1)=='.'?answer.substring(0,answer.length()-1):answer;
        answer=answer.length()==0?"a":answer;
        answer=answer.length()<=15?answer:answer.charAt(14)=='.'?answer.substring(0,14):answer.substring(0,15);
        answer=answer.length()<=2?answer.substring(0,1)+answer.substring(answer.length()-1).repeat(2):answer;


        return answer;
    }

    public static void main(String[] args){
        String result=solution("=.=");
        System.out.println(result);
    }

}
