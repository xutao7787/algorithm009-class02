package Week02;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。

 进阶:
 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

 */
public class IsAnagram_242 {

    public boolean isAnagramBySort(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr,tArr);
    }

    public boolean isAnagramByMap(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i - 'a')]++;
            counter[t.charAt(i - 'a')]--;
        }

        for (int count:
             counter) {
            if(count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        IsAnagram_242 isAnagram_242 = new IsAnagram_242();
        isAnagram_242.isAnagramByMap("aacc","ccac");
    }
}
