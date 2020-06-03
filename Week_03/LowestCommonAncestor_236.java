package Week03;

import utils.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * Created by xutao on 2020/6/3.
 */
public class LowestCommonAncestor_236 {

    private TreeNode ans;

    public LowestCommonAncestor_236() {
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);

        if((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            this.ans = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
    }

}
