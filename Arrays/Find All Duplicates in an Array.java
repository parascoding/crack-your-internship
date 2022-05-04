class Solution {
    public List<Integer> findDuplicates(int[] a) {
        int n=a.length;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int ind=(Math.abs(a[i])-1);
            if(a[ind]<0)
                ans.add(ind+1);
            a[ind]=-a[ind];
        }
        return ans;
    }
}
