class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] a) {
        int n=a.length, m=a[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='1'){
                    bfs(a,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }
    void bfs(char a[][], int i, int j, int n, int m){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int temp[]=q.poll();
            for(int k=0;k<8;k++){
                int xi=temp[0]+dx[k];
                int xj=temp[1]+dy[k];
                if(isSafe(xi,xj,n,m)&&a[xi][xj]=='1'){
                    q.add(new int[]{xi,xj});
                    a[xi][xj]='2';
                }
            }
        }
    }
    boolean isSafe(int i, int j, int n, int m){
        return i>-1&&i<n&&j>-1&&j<m;
    }
    int dx[]={-1,-1,-1,0,0,1,1,1};
    int dy[]={-1,0,1,-1,1,-1,0,1};
}
