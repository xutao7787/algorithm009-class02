package Week_06;

/**
 *
 * Created by xutao on 2020/6/28.
 */
public class CountSubstrings_647 {

    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int res = len;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = len - 1; i >= 0 ; i--) {
            for (int j = i + 1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if(dp[i][j]) {
                    res++;
                }
            }
        }

        return res;
    }

}
