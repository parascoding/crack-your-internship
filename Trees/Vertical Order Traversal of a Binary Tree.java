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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ans=new ArrayList<>();
        hm=new HashMap<>();
        left=0;
        right=0;
        solve(root,0,0);
        int size=right-left+1;
        for(int i=0;i<size;i++)
            ans.add(new ArrayList<>());
        for(Map.Entry<Integer,Set<Node>> e:hm.entrySet()){
            int ind=e.getKey();
            ind-=left;
            for(Node x:e.getValue()){
                ans.get(ind).add(x);
            }
            Collections.sort(ans.get(ind),
                new Comparator<Node>(){
                    public int compare(Node n1,Node n2){
                        if(n1.level==n2.level) return n1.val-n2.val;
                        return n1.level-n2.level;
                    }
                }
            );
        }
        List<List<Integer>> ret=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            List<Integer> temp=new ArrayList<>();
            for(Node x:ans.get(i)){
                temp.add(x.val);
            }
            ret.add(new ArrayList<>(temp));
        }
        return ret;
        
    }
    void solve(TreeNode root, int dis, int level){
        if(root==null) return;
        if(!hm.containsKey(dis))
            hm.put(dis,new HashSet<Node>());
        hm.get(dis).add(new Node(root.val, level));
        if(dis<left)left=dis;
        if(dis>right) right=dis;
        solve(root.left,dis-1,level+1);
        solve(root.right,dis+1,level+1);
    }
    static class Node{
        int val;
        int level;
        Node(int val, int level){
            this.val=val;
            this.level=level;
        }
    }
    int left,right;
    List<List<Node>> ans;
    Map<Integer,Set<Node>> hm;
}
