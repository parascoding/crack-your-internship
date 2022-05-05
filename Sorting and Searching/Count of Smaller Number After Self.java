class Solution {
    public List<Integer> countSmaller(int[] nums) {
        a=nums;
        bit=new int[n];
        List<Integer> ans=new ArrayList<>();
        for(int i=a.length-1;i>-1;i--){
            a[i]+=del;
            ans.add(find(a[i]-1));
            update(a[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
    static void update(int ind){
        while(ind<=n){
            bit[ind]++;
            ind+=(ind&(-ind));
        }
    }
    static int find(int ind){
        int sum=0;
        while(ind>0){
            sum+=bit[ind];
            ind-=(ind&(-ind));
        }
        return sum;
    }
    static int del=10001;
    static int n=2*del+1;
    static int bit[],a[];
        
}
