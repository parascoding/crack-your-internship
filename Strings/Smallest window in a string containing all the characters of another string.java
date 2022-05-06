class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p){
        int map[]=new int[128];
        for(char c:p.toCharArray()) map[c]++;
        
        int low=0, high=0, minLen=Integer.MAX_VALUE, start=0,n=s.length();
        int count=p.length();
        while(high<n){
            char c1=s.charAt(high);
            if(map[c1]>0) count--;
            map[c1]--;
            high++;
            while(count==0){
                if(minLen>high-low){
                    minLen=high-low;
                    start=low;
                }
                char c2=s.charAt(low++);
                map[c2]++;
                if(map[c2]>0) count++;
                
            }
        }
        return minLen==Integer.MAX_VALUE?"-1":s.substring(start, start+minLen);
    }
}
