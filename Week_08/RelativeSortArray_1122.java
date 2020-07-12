package Week_08;

import java.util.Arrays;

/**
 * 1122. 数组的相对排序
 * Created by xutao on 2020/7/11.
 */
public class RelativeSortArray_1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int n1 : arr1) {
            count[n1]++;
        }

        int index = 0;

        for (int n2 : arr2) {
            while (count[n2] > 0) {
                arr1[index++] = n2;
                count[n2]--;
            }
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }

        return arr1;
    }

}
