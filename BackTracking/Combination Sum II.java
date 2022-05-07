class Solution {
    public List<List<Integer>> combinationSum2(int[] a, int k) {
        ans=new ArrayList<>();
        n=a.length;
        Arrays.sort(a);
        solve(a,new ArrayList<>(), k, 0,0);
        return ans;
    }
    void solve(int a[], ArrayList<Integer> tempAns, int k, int ind, int sum){
        if(sum>=k){
            if(sum==k){
                ans.add(new ArrayList<>(tempAns));
            }
            return;
        }   
        for(int i=ind;i<n;i++){
            if(i>ind&&a[i]==a[i-1])
                continue;
            tempAns.add(a[i]);
            solve(a, tempAns, k, i+1, sum+a[i]);
            tempAns.remove(tempAns.size()-1);
        }
    }
    List<List<Integer>> ans;
    int n;
}
