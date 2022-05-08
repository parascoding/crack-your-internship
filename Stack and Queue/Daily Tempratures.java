class Solution {
    public int[] dailyTemperatures(int[] a) {
        int n=a.length;
        int ans[]=new int[n];
        ans[n-1]=n;
        for(int i=n-2;i>-1;i--){
            int p=i+1;
            while(p<n&&a[p]<=a[i])
                p=ans[p];
            ans[i]=p;
        }
        for(int i=0;i<n;i++){
            if(ans[i]==n) ans[i]=0;
            else ans[i]-=i;
        }
        return ans;
    }
}
