class Solution {
    public int findTheCity(int n, int[][] e, int K) {
        dp=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], 100000);    
        for(int x[]:e){
            dp[x[0]][x[1]]=x[2];
            dp[x[1]][x[0]]=x[2];
        }
        for(int i=0;i<n;i++) dp[i][i]=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }
        int min=n,ans=-1;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++) if(dp[i][j]<=K) count++;
            if(count<=min){min=count;ans=i;}
        }
        return ans;
    }
    static int dp[][];
}
