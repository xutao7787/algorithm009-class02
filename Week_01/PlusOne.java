/**
 * Created by xutao on 2020/3/23.
 */
public class PlusOne {

    /**
     * 66. 加一
     给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

     最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

     你可以假设除了整数 0 之外，这个整数不会以零开头。

     示例 1:

     输入: [1,2,3]
     输出: [1,2,4]
     解释: 输入数组表示数字 123。
     示例 2:

     输入: [4,3,2,1]
     输出: [4,3,2,2]
     解释: 输入数组表示数字 4321。

     */
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return digits;
        }
        //增值变量  1 or 0   1时代表发生了进制
        int carry = 1;
        for(int i = digits.length - 1 ; i >= 0 ; i--) {
            int val = digits[i] + carry;
            digits[i] = val % 10;
            carry = val / 10;
        }

        //最后carry为1  说明首位也发生进制  需要扩容数组
        if(carry == 1){
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            for(int i = 0 ; i < digits.length ; i++) {
                newArray[i+1] = digits[i];
            }

            return newArray;
        }

        return digits;
    }



}
