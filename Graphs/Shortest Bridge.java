class Solution {
    public int shortestBridge(int[][] a) {
        n=a.length;m=a[0].length;
        boolean flag=false;
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==1){
                    dfs(a,i,j,q);
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }
        
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node temp=q.poll();
                
                for(int k=0;k<4;k++){
                    int xi=temp.i+dx[k];
                    int xj=temp.j+dy[k];
                    if(isSafe(xi,xj)&&(a[xi][xj]==0||a[xi][xj]==1)){
                        if(a[xi][xj]==1) return ans;
                        q.add(new Node(xi,xj));
                        a[xi][xj]=-1;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
    void dfs(int a[][],int i,int j,Queue<Node> q){
        a[i][j]=-1;
        q.add(new Node(i,j));
        for(int k=0;k<4;k++){
            int xi=i+dx[k];
            int xj=j+dy[k];
            if(isSafe(xi,xj)&&a[xi][xj]==1)
                dfs(a,xi,xj,q);
        }
    }
    boolean isSafe(int i, int j){
        return i>-1&&i<n&&j>-1&&j<m;
    }
    int n,m;
    int dx[]={1,-1,0,0};
    int dy[]={0,0,-1,1};
    
    static class Node{
        int i,j;
        Node(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
}
