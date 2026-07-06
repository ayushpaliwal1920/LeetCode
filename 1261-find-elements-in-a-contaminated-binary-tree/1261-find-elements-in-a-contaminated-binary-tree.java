/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;

        if(root != null){
            root.val = 0;
            recover(root);        
        }
    }

    public void recover(TreeNode root){
        if( root == null) return ;

        if( root.left != null){
            root.left.val = 2 * root.val + 1;
            recover(root.left);
        }

        if( root.right != null){
            root.right.val = 2*root.val + 2;
            recover(root.right);
        }
    }

    public boolean find(int target){
        return search(target , root);
    }
    
    public boolean search(int target , TreeNode root) {

        if( root == null) return false;

        if( root.val == target) return true;

        return search(target ,root.left ) || search(target , root.right);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */