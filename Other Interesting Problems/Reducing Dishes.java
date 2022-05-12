class Solution {
    public int maxSatisfaction(int[] a) {
        Arrays.sort(a);
        int n=a.length;
        int ans=0, sum=0;
        for(int i=n-1;i>-1&&a[i]>-sum;i--){
            sum+=a[i];
            ans+=sum;
        }
        return ans;
        
    }
}
