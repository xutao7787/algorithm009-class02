package Week_04;

/**
 * 33. 搜索旋转排序数组
 * Created by xutao on 2020/6/13.
 */
public class Search_33 {

    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0) return -1;
        int left = 0,right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target ) {
                return mid;
            }

            if(nums[left] <= nums[mid]) {
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

}
