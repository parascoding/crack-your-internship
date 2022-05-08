/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    String splitter=",", nullNode="X";
    StringBuilder sb;
    public String serialize(TreeNode root) {
        sb=new StringBuilder();
        build(root);
        return sb.toString();
    }
    void build(TreeNode root){
        if(root==null){
            sb.append(nullNode).append(splitter);
            return;
        }
        sb.append(root.val).append(splitter);
        build(root.left);
        build(root.right);
    }
    public TreeNode deserialize(String s) {
        List<String> list=new ArrayList<>();
        list.addAll(Arrays.asList(s.split(splitter)));
        ind=0;
        return solve(list);
    }
    int ind;
    public TreeNode solve(List<String> list){
        if(list.get(ind).equals(nullNode)){ind++;return null;}
        TreeNode root=new TreeNode(Integer.parseInt(list.get(ind++)));
        root.left=solve(list);
        root.right=solve(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
