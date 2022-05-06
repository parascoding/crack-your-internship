class Solution {
    public String longestCommonPrefix(String[] s) {
        root=new Trie();
        for(String x:s) insert(x);
        Trie node=root;
        StringBuilder sb=new StringBuilder("");
        while(true){
            int max=0, ind=-1;
            for(int i=0;i<26;i++){
                if(node.child[i]!=null&&node.child[i].count>max){
                    max=node.child[i].count;
                    ind=i;
                }
            }
            if(max<s.length||ind==-1) break;
            sb.append((char)('a'+ind));
            node=node.child[ind];
        }
        return sb.toString();
    }
    Trie root;
    void insert(String s){
        char ch[]=s.toCharArray();
        Trie node=root;
        for(int i=0;i<ch.length;i++){
            int ind=(int)(ch[i]-'a');
            if(node.child[ind]==null)
                node.child[ind]=new Trie();
            node=node.child[ind];
            node.count++;
        }
    }
    class Trie{
        int count;
        Trie child[];
        Trie(){
            count=0;
            child=new Trie[26];
        }
    }
}
