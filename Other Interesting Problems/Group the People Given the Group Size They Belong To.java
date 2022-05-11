class Solution {
    public List<List<Integer>> groupThePeople(int[] a) {
        hm=new HashMap<>();
        int n=a.length;
        for(int i=0;i<n;i++){
            if(!hm.containsKey(a[i])) hm.put(a[i], new ArrayList<>());
            hm.get(a[i]).add(i);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> e:hm.entrySet()){
            int key=e.getKey();
            List<Integer> val=e.getValue();
            List<Integer> temp=new ArrayList<>();
            int i=0;
            while(i<val.size()){
                temp.add(val.get(i));
                if((i+1)%key==0){
                    ans.add(new ArrayList<>(temp));
                    temp=new ArrayList<>();
                }
                i++;
            }
        }
        return ans;
    }
    
    Map<Integer, List<Integer>> hm;
}
