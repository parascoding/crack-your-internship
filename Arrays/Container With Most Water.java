class Solution {
    public int maxArea(int[] a) {
        int n=a.length;
        int i=0,j=n-1;
        int ans=-1;
        while(i<j)
        {
            int h=Math.min(a[i],a[j]);
            ans=Math.max(ans,(j-i)*h);
            while(a[i]<=h&&i<j) i++;
            while(a[j]<=h&&i<j) j--;
        }
        return ans;
    }
}
