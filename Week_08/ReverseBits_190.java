package Week_08;

/**
 * 190. 颠倒二进制位
 * Created by xutao on 2020/7/9.
 */
public class ReverseBits_190 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <= 32; i++) {
            //将给定的二进制数，由低到高位逐个取出
            //右移i位
            int temp = n >> i;
            //取有效位
            temp = temp & 1;
            //通过位运算将其放到反转后的位置
            temp = temp << (31 - i);
            //将上述结果再次通过位运算结合到一起
            res |= temp;
        }
        return res;
    }

}
