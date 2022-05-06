class Solution {
    public int maximalSquare(char[][] a) {
        int n=a.length, m=a[0].length;
        int dp[][]=new int[n][m];
        int max=0;
        for(int i=0;i<n;i++) {dp[i][0]=(int)(a[i][0]-'0');max=dp[i][0]==1?1:max;}
        for(int j=0;j<m;j++) {dp[0][j]=(int)(a[0][j]-'0');max=dp[0][j]==1?1:max;}
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(a[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    max=Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
