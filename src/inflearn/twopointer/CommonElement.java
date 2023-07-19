package inflearn.twopointer;

import java.util.*;

public class CommonElement {
  public static void sortArr(int[]arr){
    Arrays.sort(arr);
    return;
  }

  public static int[] solution(int[] a,int[] b){
    sortArr(a);
    sortArr(b);
    int p1=0,p2=0;
    List<Integer> l=new ArrayList();
    while(p1<a.length&&p2<b.length){
      if(a[p1]==b[p2]){
        l.add(a[p1]);
        p1++;
        p2++;
      }
      else if(a[p1]>b[p2])p2++;
      else p1++;
    };
    return l.stream().mapToInt(i->i).toArray();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int[]a=new int[n];
    for(int i=0;i<n;i++)a[i]=sc.nextInt();

    n=sc.nextInt();
    int[]b=new int[n];
    for(int i=0;i<n;i++)b[i]=sc.nextInt();

    int[] result=solution(a,b);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i]+" ");
    }
  }

}
