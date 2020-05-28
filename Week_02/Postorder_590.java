package Week02;

import java.util.*;

/**
 * 590. N叉树的后序遍历
 给定一个 N 叉树，返回其节点值的后序遍历。

 说明: 递归法很简单，你可以使用迭代法完成此题吗?

 */
public class Postorder_590 {


    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        order(root,res);
        return res;
    }

    private void order(Node node,List<Integer> list) {
        for (Node n: node.children) {
            order(n, list);
        }
        list.add(node.val);
    };


    /**
     * 迭代方式
     * @param root
     * @return
     */
    public List<Integer> postorderByLoop(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.addFirst(node.val);
            for (Node n : node.children) {
                if(n != null) {
                    stack.add(n);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Postorder_590 Postorder_590 = new Postorder_590();
//        Postorder_590.postorder();
    }



}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
