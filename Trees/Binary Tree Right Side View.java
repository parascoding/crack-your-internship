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
    public List<Integer> rightSideView(TreeNode root) {
        ans=new ArrayList<>();
        solve(root, 0);
        return ans;
    }
    void solve(TreeNode root, int level){
        if(root==null) return;
        if(level==ans.size()) 
            ans.add(root.val);
        solve(root.right, 1+level);
        solve(root.left, 1+level);
    }
    List<Integer> ans;
}
