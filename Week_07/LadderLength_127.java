package Week_07;

import javafx.util.Pair;

import java.util.*;

/**
 * 单词接龙 - 127
 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

 每次转换只能改变一个字母。
 转换过程中的中间单词必须是字典中的单词。
 说明:

 如果不存在这样的转换序列，返回 0。
 所有单词具有相同的长度。
 所有单词只由小写字母组成。
 字典中不存在重复的单词。
 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 示例 1:

 输入:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 输出: 5

 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 返回它的长度 5。
 示例 2:

 输入:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 输出: 0

 解释: endWord "cog" 不在字典中，所以无法进行转换。

 */
public class LadderLength_127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String currWord = queue.remove();
                for (String word : wordList) {
                    if(visited.contains(word)) continue;

                    if(!canConvert(currWord,word)) continue;

                    if(word.equals(endWord)) {
                        return level + 1;
                    }

                    visited.add(word);
                    queue.offer(word);
                }
            }
        }

        return 0;
    }

    private static boolean canConvert(String currWord, String word) {
        if (currWord.length() != word.length()) return false;
        int count = 0;
        for (int i = 0; i < currWord.length(); i++) {
            if(currWord.charAt(i) != word.charAt(i)) {
                count++;
            }

            if(count > 1) return false;
        }

        return count == 1;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        LadderLength_127.ladderLengthTwoBFS("hit","cog",list);
    }

    public static int ladderLengthTwoBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int steps = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chars[i];
                        if(old == c) continue;
                        chars[i] = c;
                        String target = String.valueOf(chars);
                        if(endSet.contains(target)) {
                            return steps + 1;
                        }

                        if(!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chars[i] = old;
                    }
                }
            }
            beginSet = temp;
            steps++;
        }

        return 0;
    }

}
