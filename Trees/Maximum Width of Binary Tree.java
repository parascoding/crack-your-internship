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
    public int widthOfBinaryTree(TreeNode root) {
        hm=new HashMap<>();
        ans=0;
        solve(root,0,0);
        for(int x:hm.keySet()){
            ans=Math.max(ans, hm.get(x).max-hm.get(x).min+1);
        }
        
        return ans;
    }
    private void solve(TreeNode root, int level,int num){
        if(root==null) return;        
        solve(root.left,level+1, 2*num+1);
        if(!hm.containsKey(level)){
            hm.put(level,new Node());
            hm.get(level).min=num;
        }
        hm.get(level).max=num;
        solve(root.right, level+1,2*num+2);
    
    }
    private HashMap<Integer,Node> hm;
    static class Node{
        int min, max;
        Node(){min=0;max=0;}
    }
    private int ans;
}
