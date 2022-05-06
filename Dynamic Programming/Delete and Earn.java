class Solution {
    public int deleteAndEarn(int[] a) {
        int max=0;
        for(int x:a) if(x>max) max=x;
        int temp[]=new int[max+1];
        for(int x:a)
            temp[x]++;
        int dp[]=new int[max+1];
        dp[0]=0;
        if(max==0) return dp[0];
        dp[1]=Math.max(dp[0],temp[1]);
        for(int i=2;i<=max;i++)
            dp[i]=Math.max(dp[i-1], dp[i-2]+i*temp[i]);
        return dp[max];
    }
}
