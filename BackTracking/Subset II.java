class Solution {
    public List<List<Integer>> subsetsWithDup(int[] a) {
        ans=new ArrayList<>();
        Arrays.sort(a);
        solve(a, a.length, 0,new ArrayList<>());
        return ans;
    }
    void solve(int a[], int n, int ind, ArrayList<Integer> tempAns){
        ans.add(new ArrayList<>(tempAns));
        for(int i=ind;i<n;i++){
            if(i>ind&&a[i]==a[i-1])
                continue;
            tempAns.add(a[i]);
            solve(a, n, i+1, tempAns);
            tempAns.remove(tempAns.size()-1);
        }
    }
    List<List<Integer>> ans;
}
