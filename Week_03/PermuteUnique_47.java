package Week03;

import java.util.*;

/**
 * 47. 全排列 II
 给定一个可包含重复数字的序列，返回所有不重复的全排列。

 示例:

 输入: [1,1,2]
 输出:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 */
public class PermuteUnique_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) return res;
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        //排序是能够剪支的前提
        Arrays.sort(nums);
        dfs(nums,len,0,used,path,res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        //terminator
        if(depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        //process current logic
        for (int i = 0; i < len; i++) {
            if(used[i]) {
                continue;
            }

            //剪支操作   重复元素   上一个元素刚刚回溯撤销过
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth + 1,used , path ,res);
            //restore current status
            used[i] = false;
            path.removeLast();
        }
    }

}
