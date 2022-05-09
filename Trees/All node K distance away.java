/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        hm=new HashMap<>();
        ans=new ArrayList<>();
        build(root, target);
        solve(root, k, 0);
        return ans;
    }
    void solve(TreeNode root, int k, int dis){
        if(root==null) return;
        if(hm.containsKey(root))
            dis=hm.get(root);
        if(dis==k) ans.add(root.val);
        solve(root.left, k, dis+1);
        solve(root.right, k, dis+1);
    }
    int build(TreeNode root, TreeNode target){
        if(root==null) return -1;
        if(root==target){
            hm.put(root, 0);
            return 0;
        } 
        int left=build(root.left, target);
        if(left>=0){
            hm.put(root, left+1);
            return left+1;
        }
        int right=build(root.right, target);
        if(right>=0){
            hm.put(root, right+1);
            return right+1;
        }
        return -1;
    }
    Map<TreeNode, Integer> hm;
    List<Integer> ans;
}
