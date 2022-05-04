class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        int n=a.length,m=a[0].length;
        visited=new boolean[n][m];
        ans=new ArrayList<>();
        int dir=0;
        int count=0;
        int i=0,j=0;
        while(count<n*m){
            ans.add(a[i][j]);
            visited[i][j]=true;
            count++;
            if(count==n*m) break;
            int xi=i+dx[dir];
            int xj=j+dy[dir];
            if(!isSafe(xi,xj,n,m)||visited[xi][xj]){
                dir++;
                dir%=4;
                xi=i+dx[dir];
                xj=j+dy[dir];
            }
            i=xi;
            j=xj;
        }
        return ans;
    }
    boolean isSafe(int i, int j, int n, int m){
        return i>-1&&i<n&&j>-1&&j<m;
    }
    List<Integer> ans;
    boolean visited[][];
    int dx[]={0,1,0,-1};
    int dy[]={1,0,-1,0};
}
