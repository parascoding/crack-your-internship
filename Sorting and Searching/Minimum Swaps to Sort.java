class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int a[]){
        int n=a.length;
        int temp[]=new int[n];
        for(int i=0;i<n;i++) temp[i]=a[i];
        Arrays.sort(temp);
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++) hm.put(a[i],i);
        int count=0;
        for(int i=0;i<n;i++){
            if(temp[i]!=a[i]){
                count++;
                int ele=a[i];
                swap(a,i,hm.get(temp[i]));
                hm.put(ele, hm.get(temp[i]));
                hm.put(temp[i],i);
            }
        }
        return count;
        
    }
    void swap(int a[], int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
