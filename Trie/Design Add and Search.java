class WordDictionary {

    public WordDictionary() {
        root=new Trie();
    }
    
    public void addWord(String word) {
        insert(word.toCharArray());
    }
    static void insert(char ch[]){
        int n=ch.length;
        Trie node=root;
        for(int i=0;i<n;i++){
            int ind=(ch[i]-'a');
            if(node.child[ind]==null) node.child[ind]=new Trie();
            node=node.child[ind];
        }
        node.isEnd=true;
    }
    public boolean search(String word) {
        // System.out.println("X "+word);
        return check(word.toCharArray(),0,root);
    }
    static boolean check(char ch[], int index, Trie node){
        if(index==ch.length-1){
            
            if(ch[index]=='.') {
                for(int k=0;k<26;k++) 
                    if(node.child[k]!=null&&node.child[k].isEnd) 
                        return true;
            } else {
                int ind=ch[index]-'a';
                if(node.child[ind]==null) return false;
                return node.child[ind].isEnd;
            }
            return false;
        }
        for(int i=index;i<ch.length;i++){
            if(ch[i]=='.'){
                for(int k=0;k<26;k++){
                    if(node.child[k]!=null&&check(ch, i+1, node.child[k])) return true;
                }
                return false;
            } else{
                int ind=ch[i]-'a';
                if(node.child[ind]==null) return false;
                node=node.child[ind];
            }
        }
        return node.isEnd;
        
    }
    static Trie root;
    static class Trie{
        Trie child[];
        boolean isEnd;
        Trie(){
            child=new Trie[26];
            isEnd=false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
