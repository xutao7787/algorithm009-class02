package Week03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 * Created by xutao on 2020/6/7.
 */
public class Permute_46 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null) return ans;
        boolean[] used = new boolean[len];
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(nums,len,0,deque,used,ans);
        return ans;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> deque, boolean[] used, List<List<Integer>> ans) {
        if(depth == len) {
            ans.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < len; i++) {
            if(used[i]) {
                continue;
            }
            deque.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth + 1,deque,used,ans);
            deque.removeLast();  //回溯
            used[i] = false;
        }
    }

}
