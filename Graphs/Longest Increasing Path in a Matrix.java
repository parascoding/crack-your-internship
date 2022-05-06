class Solution {
    public int longestIncreasingPath(int[][] a) {
        n=a.length;
        m=a[0].length;
        dp=new int[n][m];
        int max=1;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                max=Math.max(max, solve(a,i,j));
        return max;
    }
    int solve(int a[][], int i, int j){
        if(dp[i][j]!=0) return dp[i][j];
        int max=1;
        for(int k=0;k<4;k++){
            int xi=i+dx[k];
            int xj=j+dy[k];
            if(isSafe(xi,xj)&&a[xi][xj]>a[i][j])
                max=Math.max(1+solve(a,xi,xj),max);
        }
        return dp[i][j]=max;
    }
    boolean isSafe(int i, int j){
        return i>-1&&i<n&&j>-1&&j<m;
    }
    int n,m,dp[][];
    int dx[]={-1,0,0,1};
    int dy[]={0,-1,1,0};
}
