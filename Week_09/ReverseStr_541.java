package Week_09;

import java.util.Arrays;

/**
 * Created by xutao on 2020/7/15.
 */
public class ReverseStr_541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i += k * 2) {
            int front = i;
            int rear = Math.min(i + k - 1,len - 1);
            reverseString(chars,front,rear);
        }

        return new String(chars);
    }

    private void reverseString(char[] s,int front,int rear) {
        while (front < rear) {
            char temp = s[front];
            s[front++] = s[rear];
            s[rear--] = temp;
        }
    }

}
