package Week_09;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * Created by xutao on 2020/7/13.
 */
public class FirstUniqChar_387 {

    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar2(String s) {
        int[] count = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            count[c - 'a']++;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (count[charArray[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}
