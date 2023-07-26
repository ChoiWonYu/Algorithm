package AlgorithmNote.Sort;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {1, 2, 5, 8, 10, 11, 16, 19};
    int targetNum = 2, lt = 0, rt = arr.length - 1, mid = 0;
    while (lt <= rt) {
      mid = (lt + rt) / 2;
      if (arr[mid] == targetNum) {
        break;
      }
      if (arr[mid] > targetNum) {
        rt = mid - 1;
      } else {
        lt = mid + 1;
      }
    }
    System.out.println("index : " + mid);
  }

}
