class NumArray {

    public NumArray(int[] a) {
        pre=new int[a.length];
        pre[0]=a[0];
        for(int i=1;i<a.length;i++)
            pre[i]=a[i]+pre[i-1];
    }
    
    public int sumRange(int left, int right) {
        return pre[right]-(left==0?0:pre[left-1]);
    }
    int pre[];
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
