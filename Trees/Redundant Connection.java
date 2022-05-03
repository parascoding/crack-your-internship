class Solution {
    public int[] findRedundantConnection(int[][] e) {
        DSU dsu=new DSU(e.length);
        int ans[]=new int[]{};
        for(int x[]:e){
            if(!dsu.union(x[0],x[1]))
                ans=x;
        }
        return ans;
    }
    static class DSU{
        int par[];
        int rank[];
        DSU(int n){
            n++;
            par=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++)
                par[i]=i;
        }
        int find(int node){
            if(node==par[node]) return node;
            return par[node]=find(par[node]);
        }
        boolean union(int u, int v){
            u=find(u);
            v=find(v);
            if(u==v) return false;
            if(rank[u]>rank[v])
                par[v]=u;
            else if(rank[v]>rank[u])
                par[u]=v;
            else{
                par[u]=v;
                rank[v]++;
            }
            return true;
        }
    }
}
