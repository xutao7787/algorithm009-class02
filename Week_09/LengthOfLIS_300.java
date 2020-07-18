package Week_09;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * Created by xutao on 2020/7/16.
 */
public class LengthOfLIS_300 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;

        int[] dp = new int[len];
        Arrays.fill(dp,1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res,dp[i]);
        }

        return res;
    }

}
