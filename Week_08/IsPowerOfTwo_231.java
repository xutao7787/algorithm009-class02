package Week_08;

/**
 * 231. 2的幂
 * Created by xutao on 2020/7/11.
 */
public class IsPowerOfTwo_231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        if(n <= 0) return false;
        while (n % 2 == 0) {
            n = n / 2;
        }

        return n == 1;
    }

}
