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
    public int minCameraCover(TreeNode root) {
        if(solve(root)==-1) count++;
        return count;
    }
    int solve(TreeNode root){
        if(root==null) return 1;
        int l=solve(root.left);
        int r=solve(root.right);
        
        if(l==-1||r==-1){
            count++;
            return 0;
        } 
        if(l==0||r==0){
            return 1;
        }
        return -1;
    }
    int count=0;
}
