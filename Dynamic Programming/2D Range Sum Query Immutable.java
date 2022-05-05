class NumMatrix {

    public NumMatrix(int[][] mat) {
        a=mat;
        n=a.length;m=a[0].length;
        
        for(int j=1;j<m;j++)
            a[0][j]+=a[0][j-1];
        for(int i=1;i<n;i++)
            a[i][0]+=a[i-1][0];
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
                a[i][j]+=(a[i-1][j]+a[i][j-1]-a[i-1][j-1]);
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int s=a[r2][c2];
        int dx1=0,dx2=0,dx3=0;
        if(c1>0)
            dx1=a[r2][c1-1];
        if(r1>0)
            dx2=a[r1-1][c2];
        if(r1>0&&c1>0)
            dx3=a[r1-1][c1-1];
        return s-dx1-dx2+dx3;
        
    }
    int n,m;
    int a[][];
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
