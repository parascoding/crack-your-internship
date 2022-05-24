class Solution {
    public int findPeakElement(int[] a) {
        int low=0, high=a.length-1;
        while(low<high){
            int mid=(low+high)/2;
            if(a[mid]<a[mid+1])
                low=mid+1;
            else 
                high=mid;
        }
        return low;
    }
}
