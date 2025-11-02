package AlgorithmNote.Sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }

        int mid = (high + low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] lArr = new int[n1];
        int[] rArr = new int[n2];

        System.arraycopy(arr, low, lArr, 0, n1);
        System.arraycopy(arr, mid + 1, rArr, 0, n2);

        int p1 = 0;
        int p2 = 0;
        int idx = low;
        while (p1 < n1 && p2 < n2) {
            if (lArr[p1] > rArr[p2]) {
                arr[idx++] = rArr[p2++];
            } else {
                arr[idx++] = lArr[p1++];
            }
        }

        while (p1 < n1) {
            arr[idx++] = lArr[p1++];
        }

        while (p2 < n2) {
            arr[idx++] = rArr[p2++];
        }
    }
}
