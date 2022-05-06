class Solution {
    public boolean canJump(int[] a) {
        int n=a.length;
        int pos=n-1;
        for(int i=n-1;i>-1;i--){
            if(i+a[i]>=pos) pos=i;
        }
        return pos==0;
    }
}
