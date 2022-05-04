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
    public int pathSum(TreeNode root, int targetSum) {
        hm=new HashMap<>();
        count=0;
        hm.put(0,1);
        solve(root, targetSum, 0);
        return count;
    }
    static void solve(TreeNode root, int k, int sum){
        if(root==null) return;
        sum+=root.val;
        count+=hm.getOrDefault(sum-k, 0);
        hm.put(sum, hm.getOrDefault(sum,0)+1);
        solve(root.left, k, sum);
        solve(root.right, k, sum);
        hm.put(sum, hm.get(sum)-1);
    }
    static Map<Integer,Integer> hm;
    static int count=0;
}
