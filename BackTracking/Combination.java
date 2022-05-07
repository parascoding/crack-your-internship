class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        solve(1, n, k, new ArrayList<>(),0);
        return ans;
    }
    void solve(int count, int n, int k, ArrayList<Integer> tempAns, int size){
        if(size==k){
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        if(size<k){
            for(int i=count;i<=n;i++){
                tempAns.add(i);
                solve(i+1, n,k,tempAns, size+1);
                tempAns.remove(tempAns.size()-1);
            }
        }
    }
    List<List<Integer>> ans;
}
