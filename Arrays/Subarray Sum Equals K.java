class Solution {
    public int subarraySum(int[] a, int k) {
        int n=a.length;
        Map<Integer,Integer> hm=new HashMap<>();
        int sum=0;
        hm.put(sum,1);
        int count=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            count+=hm.getOrDefault(sum-k,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
