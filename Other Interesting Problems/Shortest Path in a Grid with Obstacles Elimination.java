class Solution {
    public int shortestPath(int[][] grid, int k) {
        a=grid;
        n=a.length;m=a[0].length;
        visited=new boolean[n][m][k+1];
        return find(k);
    }
    static int find(int K){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,0});
        int ans=0;
        visited[0][0][0]=true;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int temp[]=q.poll();
                if(temp[0]==n-1&&temp[1]==m-1) return ans;
                
                for(int k=0;k<4;k++){
                    int xi=temp[0]+dx[k];
                    int xj=temp[1]+dy[k];
                    int cost=temp[2];
                    if(isSafe(xi,xj)){
                        if(a[xi][xj]==1)
                            cost++;
                        if(cost<=K&&!visited[xi][xj][cost]){
                            q.add(new int[]{xi,xj,cost});
                            visited[xi][xj][cost]=true;
                        }
                    }
                        
                }
            }
            ans++;
        }
        return -1;
    }
    
    static int a[][], n,m, dx[]={-1,0,0,1},dy[]={0,-1,1,0};
    static boolean visited[][][];
    static boolean isSafe(int i, int j){
        return i>-1&&i<n&&j>-1&&j<m;
    }
}
