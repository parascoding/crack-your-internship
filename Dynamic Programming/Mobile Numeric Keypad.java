class Solution
{
	public long getCount(int n){
		dp=new long[n+1][4][3];
		long count=0;
		for(int i=0;i<3;i++){
		    for(int j=0;j<3;j++){
		        count+=solve(i,j,n);
		    }
		}
		count+=solve(3,1,n);
		return count;
	}
	long solve(int i, int j, int n){
	    if(n==1) return 1L;
	    if(dp[n][i][j]!=0) return dp[n][i][j];
	    long sum=0;
	    for(int k=0;k<5;k++){
	        int xi=i+dx[k];
	        int xj=j+dy[k];
	        if(isSafe(xi,xj))
	            sum+=solve(xi,xj,n-1);
	    }
	    return dp[n][i][j]=sum;
	}
	boolean isSafe(int i, int j){
	    if(i==3&&j!=1) return false;
	    return i>-1&&i<4&&j>-1&&j<3;
	    
	}
	int dx[]={-1,0,0,1,0};
	int dy[]={0,-1,1,0,0};
	long dp[][][];
}
