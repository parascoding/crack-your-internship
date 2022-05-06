class Solution {
    public int makeConnected(int n, int[][] e) {
        if(e.length<n-1) return -1;
        int count=0;
        DSU dsu=new DSU(n);
        for(int x[]:e){
            if(!dsu.union(x[0],x[1]))
                count++;
        }
        return dsu.ele;
    }
    class DSU{
        int par[],rank[];
        int ele;
        DSU(int n){
            par=new int[n];
            rank=new int[n];
            ele=n-1;
            for(int i=0;i<n;i++) par[i]=i;
        }
        int find(int node){
            if(par[node]==node) return node;
            return par[node]=find(par[node]);
        }
        boolean union(int u, int v){
            u=find(u);
            v=find(v);
            if(v==u) return false;
            if(rank[u]>rank[v])
                par[v]=u;
            else if(rank[v]>rank[u])
                par[u]=v;
            else{
                par[v]=u;
                rank[u]++;
            }
            ele--;
            return true;
        }
    }
}
