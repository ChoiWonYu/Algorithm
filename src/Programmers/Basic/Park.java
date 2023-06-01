package Programmers.Basic;

import java.util.StringTokenizer;

public class Park {
    private static int[] location=new int[2];

    private static char[][]p;

    public static int[] solution(String[] park, String[] routes) {
        makePark(park);
        for(String S:routes){
            StringTokenizer st=new StringTokenizer(S);
            String cmd=st.nextToken();
            int vol=Integer.parseInt(st.nextToken());
            int [] tempLocation=new int[2];
            tempLocation[0]=location[0];
            tempLocation[1]=location[1];
            for(int i=0;i<vol;i++) {
                try {
                    tempLocation = handleCommend(tempLocation, cmd);
                }catch(Exception e){
                    break;
                }
                if(i==vol-1)commitLocation(tempLocation);
            }

        }
        return location;
    }

    public static void commitLocation(int[] tempLocation){
        location[0]=tempLocation[0];
        location[1]=tempLocation[1];
    }
    public static boolean isValid(int x,int y){
        if(y>=p.length||y<0)return false;
        if(x>=p[0].length||x<0)return false;
        if(p[y][x]=='X')return false;
        return true;
    }

    public static int[] handleCommend(int[] l,String direction) throws Exception{
        int []testLocation=l;
        switch(direction){
            case "E":
                testLocation[1]+=1;
                break;
            case "W":
                testLocation[1]-=1;
                break;
            case "N":
                testLocation[0]-=1;
                break;
            case "S":
                testLocation[0]+=1;
                break;
            default:
                throw new Exception();
        }
        if(!isValid(testLocation[1],testLocation[0]))throw new Exception();
        return testLocation;
    }

    public static char[][] makePark(String[] park){
        int xLength=park[0].length();
        int yLength=park.length;
        p=new char[yLength][xLength];
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                p[i][j]=park[i].charAt(j);
                if(p[i][j]=='S') {
                    location[0]=i;
                    location[1]=j;
                }
            }
        }
        return p;
    }

    public static void main(String[] args)throws Exception{
        String[]p={"SOO","OOO","OOO"};
        String[]r={"E 2","S 2","W 1"};

        int[]answer=solution(p,r);
        for(int i:answer)System.out.println(i);
    }

}
