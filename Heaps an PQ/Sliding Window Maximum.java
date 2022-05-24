class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n=a.length;
        int ans[]=new int[n-k+1];
        int right[]=new int[n];
        right[n-1]=n;
        int len=n-k;
        for(int i=n-2;i>-1;i--){
            int p=i+1;
            while(p<n&&a[p]<=a[i])
                p=right[p];
            right[i]=p;
        }
        int i=0,j=0;
        while(i<=len){
            if(j<i)
                j=i;
            while(right[j]<i+k)
                j=right[j];
            if(j==n)
                ans[i]=a[i];
            else
                ans[i]=a[j];
            i++;
        }
    
        return ans;
    }
}
