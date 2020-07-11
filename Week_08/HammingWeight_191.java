package Week_08;

/**
 * 191. 位1的个数
 * Created by xutao on 2020/7/11.
 */
public class HammingWeight_191 {

    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }

        return bits;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }

}
