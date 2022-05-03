class Solution {
    public int largestRectangleArea(int[] a) {
        int n=a.length;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=-1;
        for(int i=1;i<n;i++){
            int p=i-1;
            while(p>-1&&a[p]>=a[i])
                p=left[p];
            left[i]=p;
        }
        right[n-1]=n;
        for(int i=n-2;i>-1;i--){
            int p=i+1;
            while(p<n&&a[p]>=a[i])
                p=right[p];
            right[i]=p;
        }
        int max=0;
        for(int i=0;i<n;i++){
            int t=(right[i]-left[i]-1)*a[i];
            if(t>max) max=t;
        }
        return max;
    }
}
