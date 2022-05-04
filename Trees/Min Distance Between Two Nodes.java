class GfG {
    int findDist(Node root, int a, int b) {
        Node node=lca(root, a, b);
        dis=-1;
        dis2=-1;
        if(node.data==a){
             find(node,b,0);
             return dis;
        } else if(node.data==b){
             find(node,a,0);
             return dis;
        }
        // System.out.println(node.data);
        find(node,a,0);
        find(node,b,0);
        return dis+dis2;
        
    }
    void find(Node root, int val, int level){
        if(root==null) return;
        if(root.data==val){
            if(dis==-1)
            dis=level;
            else
            dis2=level;
            return;
        }
        find(root.left,val,1+level);
        find(root.right, val, 1+level);
    }
    int dis;
    int dis2;
    Node lca(Node root, int a, int b){
        if(root==null||root.data==a||root.data==b) return root;
        Node left=lca(root.left,a,b);
        Node right=lca(root.right, a,b);
        if(left!=null&&right!=null) return root;
        if(left!=null) return left;
        return right;
    }
}
