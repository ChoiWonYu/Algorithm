package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

class Cd implements Comparable<Cd> {

  public int x;
  public int y;

  public Cd(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return this.x + " " + this.y;
  }

  @Override
  public int compareTo(Cd o) {
    return this.x != o.x ? this.x - o.x : this.y - o.y;
  }
}

public class Coordinate {

  public static Cd[] solution(Cd[] arr) {
    Arrays.sort(arr);
    return arr;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Cd[] arr = new Cd[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Cd(sc.nextInt(), sc.nextInt());
    }

    Cd[] answer = solution(arr);
    for (int i = 0; i < n; i++) {
      System.out.println(answer[i].toString());
    }
  }

}
