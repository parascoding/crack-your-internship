class Solution {
    public boolean canCross(int[] a) {
        int n=a.length;
        if(n==0) return true;
        Map<Integer,Set<Integer>> hm=new HashMap<>(n);
        for(int i=0;i<n;i++) hm.put(a[i], new HashSet<>());
        hm.get(0).add(1);
        for(int i=0;i<n-1;i++){
            int stone=a[i];
            for(int step:hm.get(stone)){
                int reach=stone+step;
                if(reach==a[n-1]) return true;
                if(hm.containsKey(reach)){
                    hm.get(reach).add(step);
                    if(step-1>0) hm.get(reach).add(step-1);
                    hm.get(reach).add(step+1);
                }
            }
        }
        return false;
        
    }
}
