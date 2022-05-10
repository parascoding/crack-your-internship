class Solution {
    public int maxCoins(int[] a) {
        int n=a.length;
        int dp[][]=new int[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;j++,i++){
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int left=(i==k?0:dp[i][k-1]);
                    int right=(k==j?0:dp[k+1][j]);
                    int val=(i==0?1:a[i-1])*a[k]*(j==n-1?1:a[j+1]);
                    max=Math.max(max, left+right+val);
                }
                dp[i][j]=max;
            }
        }
        return dp[0][n-1];
    }
}
