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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> a=new ArrayList<List<Integer>>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        if(root==null) return a;
        q.add(root);
        while(!q.isEmpty())
        {
            ArrayList<Integer> list=new ArrayList<Integer>();
            int len=q.size();
            for(int i=0;i<len;i++)
            {
                TreeNode temp=q.poll();
                list.add(temp.val);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            a.add(list);
            
            
        }return a;
    }
}
