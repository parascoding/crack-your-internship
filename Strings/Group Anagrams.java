class Solution {
    public List<List<String>> groupAnagrams(String[] s) {
        hm=new HashMap<>();
        for(String x:s){
            char ch[]=x.toCharArray();
            Arrays.sort(ch);
            String temp=new String(ch);
            if(!hm.containsKey(temp)) hm.put(temp, new ArrayList<>());
            hm.get(temp).add(x);
        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String, List<String>> e:hm.entrySet()){
            ans.add(new ArrayList<>(e.getValue()));
        }
        return ans;
    }
    Map<String,List<String>> hm;
}
