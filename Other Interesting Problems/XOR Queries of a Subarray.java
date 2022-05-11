class Solution {
    public int[] xorQueries(int[] a, int[][] q) {
        int n=a.length;
        int pre[]=new int[n], ans[]=new int[q.length];
        pre[0]=a[0];
        for(int i=1;i<n;i++) pre[i]=a[i]^pre[i-1];
        for(int i=0;i<q.length;i++){
            ans[i]=(pre[q[i][1]]^(q[i][0]==0?0:pre[q[i][0]-1]));
        }
        return ans;
    }
}
