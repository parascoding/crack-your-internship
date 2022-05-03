class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        ans=new ArrayList<>();
        Arrays.sort(a);
        int n=a.length;
        for(int i=0;i<n-2;i++){
            if (i == 0 || (i > 0 && a[i] != a[i-1])) {
                int low=i+1, high=n-1;
                int k=-a[i];
                while(low<high){
                    if(a[low]+a[high]==k){
                        ans.add(Arrays.asList(a[i], a[low], a[high]));
                        while(low<high&&a[low]==a[low+1]) low++;
                        while(low<high&&a[high]==a[high-1]) high--;
                        low++;
                        high--;
                    } else if(a[low]+a[high]<k) low++;
                    else high--;
                }
            }
        }
        return ans;
    }
    List<List<Integer>> ans;
}
