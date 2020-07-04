package Week_06;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. 单词搜索 II
 * Created by xutao on 2020/6/28.
 */
public class FindWords_212 {

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String> res = new ArrayList<>();
        for(String word : words) {
            trie.insert(word);
        }
        int rows = board.length;
        if(rows == 0) {
            return res;
        }

        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                existRecur(board,i,j,trie.root,res);
            }
        }
        return res;
    }

    private void existRecur(char[][] board, int row, int col, TrieNode node, List<String> res) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        char cur = board[row][col];

        if(cur == '$' || node.children[cur - 'a'] == null) {
            return;
        }

        node = node.children[cur - 'a'];

        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        char temp = board[row][col];

        board[row][col] = '$';
        existRecur(board,row - 1,col,node,res);
        existRecur(board,row + 1,col,node,res);
        existRecur(board,row,col - 1,node,res);
        existRecur(board,row,col + 1,node,res);
        board[row][col] = temp;
    }

}

class TrieNode {
    public TrieNode[] children;
    public String word;

    public TrieNode() {
        children = new TrieNode[26];
        word = null;
        for (int i = 0 ; i < 26 ; i++) {
            children[i] = null;
        }
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0 ; i < array.length ; i++ ) {
            if(cur.children[array[i] - 'a'] == null) {
                cur.children[array[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[array[i] - 'a'];
        }
        cur.word = word;
    }
}
