package Week02;

import java.util.*;

/**
 * 589. N叉树的前序遍历
 */
public class Preorder_589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        order(root,res);
        return res;
    }

    private void order(Node node,List list) {
        list.add(node.val);
        for (Node child : node.children) {
            order(child,list);
        }
    }


    public List<Integer> preorderByLoop(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while ( !stack.empty() ) {
            Node node = stack.pop();
            res.add(node.val);
            List<Node> chiles = node.children;
            int length = chiles.size();
            for (int i = length - 1; i >= 0; i--) {
                if(chiles.get(i) != null){
                    stack.push(chiles.get(i));
                }
            }
        }

        return res;
    }

    public List<Integer> preorderByLoop2(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while ( !stack.isEmpty() ) {
            Node node = stack.pollLast();
            res.add(node.val);
            Collections.reverse(node.children);   // 相对于上面的更耗时
            for (Node child : node.children) {
                stack.add(child);
            }
        }

        return res;
    }

}
