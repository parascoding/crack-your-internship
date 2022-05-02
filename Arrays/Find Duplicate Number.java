class Solution {
    public int findDuplicate(int[] a) {
        int slow = a[0], fast = a[a[0]];
        
        while(slow != fast){
            slow = a[slow];
            fast = a[a[fast]];
        }
        
        fast = 0;
        while(slow != fast){
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }   
}
