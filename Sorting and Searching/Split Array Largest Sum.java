class Solution {
    public int splitArray(int[] a, int m) {
        int n=a.length;
        int low=0,high=0;
        for(int x:a){
            high+=x;
            if(x>low) low=x;
        } 
        // System.out.println(low);
        while(low<=high){
            int mid=(low+high)/2;
            if(check(a,a.length,m,mid))
                high=mid-1;
            else 
                low=mid+1;
        }
        return low;
    }
    boolean check(int a[], int n, int m, int mid){
        int count=1,sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            if(sum>mid){
                count++;
                sum=a[i];
            }
        }
        return count<=m;
    }
}
