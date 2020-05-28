package Week02;

import java.util.*;

/**
 * Created by xutao on 2020/3/23.
 */
public class InorderTraversal_94 {

    /**
     * 94. 二叉树的中序遍历
     给定一个二叉树，返回它的中序 遍历。

     示例:

     输入: [1,null,2,3]
     1
     \
     2
     /
     3

     输出: [1,3,2]
     进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        order(root,res);
        return res;
    }

    private void order(TreeNode root,List<Integer> list) {
        if(root.left != null) {
            order(root.left,list);
        }
        list.add(root.val);
        if(root.right != null) {
            order(root.right,list);
        }
    }

    public List<Integer> inorderTraversalByLoop(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        while(curr != null || !st.empty()){
            while( curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
