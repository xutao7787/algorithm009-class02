package Week02;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 给定一个二叉树，返回它的 前序 遍历。

  示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,2,3]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 */
public class PreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        order(root,res);
        return res;
    }

    private void order(TreeNode node,List list) {
        list.add(node.val);
        if(node.left != null) {
            order(node.left,list);
        }
        if(node.right != null) {
            order(node.right,list);
        }
    }

    /**
     * 迭代实现
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalByLoop(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> list = new LinkedList();
        list.push(root);
        while(!list.isEmpty()) {
            TreeNode node = list.pollLast();
            res.add(node.val);
            if(node.right != null) {
                list.add(node.right);
            }
            if(node.left != null) {
                list.add(node.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PreorderTraversal_144 preorderTraversal = new PreorderTraversal_144();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;

        preorderTraversal.preorderTraversalByLoop(root);
    }


}

