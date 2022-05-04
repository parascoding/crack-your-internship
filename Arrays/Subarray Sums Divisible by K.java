class Solution {
    public int subarraysDivByK(int[] a, int k) {
        int mp[]=new int[k];
        int sum=0;
        mp[0]=1;
        int count=0;
        for(int i=0;i<a.length;i++){
            sum = (sum+a[i])%k;
            if(sum<0) sum+=k;
            count+=mp[sum];
            mp[sum]++;
        }
        return count;
    }
}
