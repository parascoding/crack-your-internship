class Solution {
    public int majorityElement(int[] a) {
        int n=a.length;
        int ele=-1, freq=0;
        for(int i=0;i<n;i++){
            if(freq==0){
                ele=a[i];
            } 
            if(a[i]==ele)
                freq++;
            else
                freq--;
        }
        return ele;
            
    }
}
