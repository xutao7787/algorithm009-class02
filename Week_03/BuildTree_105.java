package Week03;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xutao on 2020/6/7.
 */
public class BuildTree_105 {

    private Map<Integer,Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //构造哈希映射，帮我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }

        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left > preorder_right) {
            return null;
        }

        //前序遍历中的第一个根节点为根节点
        int preorder_root = preorder_left;
        //在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        //先建立根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //d得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        //递归构造左子树，并连接到根节点
        //先序遍历中 从 左边界 + 1 开始的 size_left_subtree 个元素就对应了中序遍历中 从 左边界 开始到根节点定位-1 的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

}
