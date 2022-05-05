class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> e) {
        adj=new ArrayList<>();
        ans=new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        for(List<Integer> x:e){
            adj.get(x.get(0)).add(x.get(1));
            adj.get(x.get(1)).add(x.get(0));
        }
        tin=new int[n+1];
        low=new int[n+1];
        visited=new boolean[n+1];
        time=0;
        for(int i=1;i<=n;i++)
            if(!visited[i])
                dfs(i,-1);
        return ans;
    }
    static void dfs(int node, int par){
        low[node]=tin[node]=time++;
        visited[node]=true;
        for(int v:adj.get(node)){
            if(v==par) continue;
            if(!visited[v]){
                dfs(v,node);
                if(low[v]<low[node])
                    low[node]=low[v];
                if(low[v]>tin[node]){
                    ArrayList<Integer> tempAns=new ArrayList<>();
                    tempAns.add(node);
                    tempAns.add(v);
                    ans.add(new ArrayList<>(tempAns));
                }
            } else{
                low[node]=Math.min(low[node],tin[v]);
            }
        }
    }
    static int time;
    static boolean visited[];
    static int tin[],low[];
    static List<List<Integer>> adj;
    static List<List<Integer>> ans;
}
