package Week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

 示例:

 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 * Created by xutao on 2020/6/5.
 */
public class Combine_77 {
    int n,k;
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k == 0 ) return ans;
        this.n = n;
        this.k = k;
        dfs(new LinkedList<Integer>() , 1);
        return ans;
    }

    private void dfs(LinkedList<Integer> list, int index) {
        if(list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            dfs(list,i + 1);
            list.removeLast();
        }

    }

}
