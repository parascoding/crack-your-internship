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
class Solution {
    public void flatten(TreeNode root) {
        a=new ArrayList<Integer>();
        pre(root);
        int i=1;
        int n=a.size();
        while(i<n)
        {
            root.left=null;
            root.right=new TreeNode(a.get(i++));
            root=root.right;
        }
    }
    public void pre(TreeNode root){
        if(root==null) return;
        a.add(root.val);
        pre(root.left);
        pre(root.right);
    }
    public ArrayList<Integer> a;
}
