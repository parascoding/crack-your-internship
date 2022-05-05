class Solution {
    public int findLength(int[] a1, int[] a2) {
        int n=a1.length,m=a2.length;
        int dp[][]=new int[n+1][m+1];
        int max=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a1[i-1]==a2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    if(dp[i][j]>max) max=dp[i][j];
                }
            }
        }
        return max;
    }
}
