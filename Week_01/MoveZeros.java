import java.util.HashMap;

/**
 * Created by xutao on 2020/3/23.
 */
public class MoveZeros {

    /**
     * 283. 移动零
     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

     示例:

     输入: [0,1,0,3,12]
     输出: [1,3,12,0,0]
     说明:

     必须在原数组上操作，不能拷贝额外的数组。
     尽量减少操作次数。
     */
     public void moveZeroes(int[] nums) {
         int notZeroIndex = 0;
         for(int i = 0 ; i < nums.length ; i++) {
             if(nums[i] != 0){
                 int temp = nums[notZeroIndex];
                 nums[notZeroIndex] = nums[i];
                 nums[i] = temp;
                 notZeroIndex++;
             }
         }
     }



}
