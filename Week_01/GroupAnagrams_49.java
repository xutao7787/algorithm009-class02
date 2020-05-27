package Week02;

import java.util.*;

/**
 * 49. 字母异位词分组
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。

 */
public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams_49 groupAnagrams = new GroupAnagrams_49();
        groupAnagrams.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    }



}
