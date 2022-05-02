class Solution {
    public void gameOfLife(int[][] a) {
        n=a.length;
        m=a[0].length;
        solve(a);
    }
    void solve(int a[][]){
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count=0;
                for(int k=0;k<8;k++){
                    int xi=i+dx[k];
                    int xj=j+dy[k];
                    if(isSafe(xi,xj,n,m)&&a[xi][xj]==1)
                        count++;
                }
                if(a[i][j]==1){
                    if(count<2)
                        ans[i][j]=0;
                    else if(count>3)
                        ans[i][j]=0;
                    else
                        ans[i][j]=1;
                } else{
                    if(count==3)
                        ans[i][j]=1;
                }
            }
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                a[i][j]=ans[i][j];
    }
    boolean isSafe(int i,int j,int n, int m){
        return i>-1&&i<n&&j>-1&&j<m;
    }
    int dx[]={-1,-1,-1,0,0,1,1,1};
    int dy[]={-1,0,1,-1,1,-1,0,1};
    int n;
    int m;
}
