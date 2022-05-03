class RandomizedCollection {

    Map<Integer,Set<Integer>> hm;
    List<Integer> list;
    public RandomizedCollection() {
        hm=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean flag=false;
        list.add(val);
        if(!hm.containsKey(val)||hm.get(val).size()==0){
            hm.put(val, new HashSet<>());
            flag=true;
        }
        hm.get(val).add(list.size()-1);

        return flag;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)||hm.get(val).size()==0) return false;
        int temp=hm.get(val).stream().findFirst().get();
        hm.get(val).remove(temp);
        Collections.swap(list, temp, list.size()-1);
        list.remove(list.size()-1);
        if(list.size()!=temp){
            int with = list.get(temp);
            hm.get(with).add(temp);
            hm.get(with).remove(list.size());
        }
        return true;
    }
    
    public int getRandom() {
        return list.get((int)(Math.random()*(list.size())));
    }
}
