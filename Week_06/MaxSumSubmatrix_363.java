package Week_06;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * Created by xutao on 2020/6/26.
 */
public class MaxSumSubmatrix_363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int rows = matrix.length,cols = matrix[0].length,max = Integer.MIN_VALUE;

        for(int l = 0 ; l < cols ; l++ ) {
            int[] rowSum = new int[rows];
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max,dpmax(rowSum,k));
                if (max == k) return k;
            }
        }

        return max;
    }

    private int dpmax(int[] arr, int k) {
        int rollSum = arr[0],rollMax = rollSum;

        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) {
                rollSum += arr[i];
            } else {
                rollSum = arr[i];
            }
            if (rollSum > rollMax) {
                rollMax = rollSum;
            }
        }

        if (rollMax <= k ) return rollMax;

        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) {
                    max = sum;
                }
                if (max == k) return k;
            }
        }
        return max;
    }

}
