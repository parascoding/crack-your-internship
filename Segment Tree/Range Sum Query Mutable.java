class NumArray {

    public NumArray(int[] nums) {
        a=nums;
        n=a.length;
        bit=new int[n+1];
        for(int i=0;i<n;i++)
            updateUtil(i, a[i]);
    }
    
    public void update(int ind, int val) {
        int del=val-a[ind];
        a[ind]=val;
        updateUtil(ind, del);
    }
    static void updateUtil(int ind, int val){
        ind++;
        while(ind<=n){
            bit[ind]+=val;
            ind+=(ind&(-ind));
        }
    }
    public int sumRange(int left, int right) {
        return sum(right+1)-sum(left);
    }
    static int sum(int ind){
        int sum=0;
        while(ind>0){
            sum+=bit[ind];
            ind-=(ind&(-ind));
        }
        return sum;
    }
    static int bit[], a[], n;
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
