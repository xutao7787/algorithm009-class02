package Week_04;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * Created by xutao on 2020/6/11.
 */
public class FindContentChildren_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int hz = 0,bg = 0;
        while(hz < g.length && bg < s.length) {
            if(g[hz] <= s[bg]) {
                hz++;
            }
            bg++;
        }
        return hz;
    }
}
