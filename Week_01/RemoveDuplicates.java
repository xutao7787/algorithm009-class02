import java.util.HashMap;

/**
 * Created by xutao on 2020/3/23.
 */
public class RemoveDuplicates {

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        //快慢指针
        //非重复项的数组下标   遇到非重复项即将其替换，并向后移动
        int notDupIndex = 0;
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[notDupIndex] != nums[i]){
                notDupIndex++;
                nums[notDupIndex] = nums[i];
            }
        }

        return notDupIndex + 1;
    }


    public static void main(String[] args){
        RemoveDuplicates test = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(test.removeDuplicates(nums));
    }


}
