class Solution {
    public int ladderLength(String start, String end, List<String> list) {
        Set<String> hs=new HashSet<>();
        for(int i=0;i<list.size();i++)
            hs.add(list.get(i));
        if(!hs.contains(end)) return 0;
        Queue<String> q=new LinkedList<>();
        q.add(start);
        int count=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String s=q.poll();
                if(s.equals(end)) return count;
                hs.remove(s);
                char ch[]=s.toCharArray();
                for(int j=0;j<s.length();j++){
                    for(int k=0;k<26;k++){
                        char temp=(char)('a'+k);
                        ch[j]=temp;
                        String ss=new String(ch);
                        if(hs.contains(ss)){
                            q.add(ss);
                            hs.remove(ss);
                        }
                    }
                    ch[j]=s.charAt(j);
                }
            }
            count++;
        }
        return 0;
    }
}
