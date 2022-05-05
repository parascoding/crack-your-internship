class Solution {
    public int coinChange(int[] a, int k) {
        int n=a.length;
        int max=k+2;
        int dp[]=new int[k+1];
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i=1;i<=k;i++)
            for(int j=0;j<n;j++)
                if(a[j]<=i)
                    dp[i]=Math.min(dp[i],1+dp[i-a[j]]);
        
        return dp[k]==max?-1:dp[k];
    }
}
