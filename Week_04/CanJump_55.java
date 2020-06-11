package Week_04;

/**
 * 55. 跳跃游戏
 输入: [2,3,1,1,4]
 输出: true
 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * Created by xutao on 2020/6/11.
 */
public class CanJump_55 {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int last = len - 1;
        for (int i = last - 1; i>=0 ; i--) {
            if(nums[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }

    public static void main(String[] args) {
        CanJump_55 canJump_55 = new CanJump_55();
        canJump_55.canJump(new int[]{3,2,1,0,4});
    }
}
