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
    public List<TreeNode> generateTrees(int n) {
        dp=new ArrayList[n+1][n+1];
        return solve(1,n);
    }
    List<TreeNode> solve(int low, int high){
        List<TreeNode> ans=new ArrayList<>();
        if(low>high){
            ans.add(null);
            return ans;
        }
        if(dp[low][high]!=null)  return dp[low][high];
        for(int i=low;i<=high;i++){
            List<TreeNode> left=solve(low, i-1);
            List<TreeNode> right=solve(i+1, high);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    ans.add(root);
                }
            }
        }
        dp[low][high]=ans;
        return ans;
    }
    List<TreeNode> dp[][];
}
