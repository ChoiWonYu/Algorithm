package BOJ.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    static int M,cnt=0,result=0;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[] nums= Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        mergeSort(nums, 0, n - 1);

        int printNum=result==0?-1:result;

        System.out.println(printNum);
    }

    private static void mergeSort(int[] nums, int p, int r) {
        if(p>=r)return;

        int q=(p+r)/2;

        mergeSort(nums,p,q);
        mergeSort(nums, q + 1, r);

        merge(nums,p,q,r);
    }

    private static void merge(int[] nums, int p, int q, int r) {
        int i=p;int j=q+1;int t=0;
        int[]tmp=new int[r-p+1];

        while (i <= q && j <= r) {
            if(nums[i]>=nums[j])tmp[t++]=nums[j++];
            else tmp[t++]=nums[i++];
        }

        while (i <= q) tmp[t++]=nums[i++];

        while(j<=r) tmp[t++] = nums[j++];

        i=p;t=0;
        while (i <= r) {
            cnt++;
            if(cnt==M)result=tmp[t];

            nums[i++] = tmp[t++];
        }
    }
}
