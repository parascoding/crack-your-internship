class Solution {
    public int maxScore(int[] a, int k) {
        int left[]=new int[k];
        int right[]=new int[k];
        int n=a.length;
        left[0]=a[0];
        for(int i=1;i<k;i++)
            left[i]=left[i-1]+a[i];
        right[0]=a[n-1];
        for(int i=1;i<k;i++){
            right[i]=right[i-1]+a[n-i-1];
        }
        int max=Math.max(left[k-1],right[k-1]);
        for(int i=0;i<k-1;i++){
            int x=left[i]+right[k-i-2];
            if(x>max) max=x;
        }
        return max;
            
    }
}
