class Solution {
    public int uniquePathsIII(int[][] a) {
        n=a.length;m=a[0].length;
        count = 0;
        int sx=-1,sy=-1;
        empty=1;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(a[i][j]==0) empty++;
                else if(a[i][j]==1){sx=i;sy=j;}        
        
        solve(a, sx, sy);
        return count;
    }
    static void solve(int a[][], int x, int y){
        if(a[x][y]==2){
            if(empty==0)
                count++;
            return;
        }
        empty--;
        a[x][y]=-2;
        for(int k=0;k<4;k++){
            int xi=x+dx[k];
            int xj=y+dy[k];
            if(isSafe(xi,xj)&&a[xi][xj]>-1)
                solve(a, xi,xj);
        }
        empty++;
        a[x][y]=0;
    }
    static boolean isSafe(int i, int j){
        return i>-1&&i<n&&j>-1&&j<m;
    }
    static int dx[]={-1,0,0,1};
    static int dy[]={0,-1,1,0};
    static int count = 0;
    static int n, m;
    static int empty;
}
