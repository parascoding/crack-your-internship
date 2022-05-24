class Solution {
    public List<String> findWords(char[][] a, String[] words) {
        root=new Trie();
        ans=new HashSet<>();
        for(String s:words) insert(s);
        n=a.length;
        m=a[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int ind = (int)(a[i][j]-'a');
                if(root.child[ind]!=null){
                    visited=new boolean[n][m];
                    visited[i][j]=true;
                    StringBuilder sb=new StringBuilder();
                    solve(a,i,j,root.child[ind],sb);
                }
            }
        }
        return new ArrayList<>(ans);
    }
    void solve(char a[][], int x, int y, Trie node,StringBuilder sb){
        visited[x][y]=true;
        sb.append(a[x][y]);
        if(node.isWord){
            ans.add(sb.toString());
        }
        for(int k=0;k<4;k++){
            int xi=x+dx[k];
            int xj=y+dy[k];
            if(isSafe(xi,xj)&&!visited[xi][xj]){
                int ind = (int)(a[xi][xj]-'a');
                if(node.child[ind]!=null){
                    solve(a,xi,xj,node.child[ind], sb);
                }
            }
        }
        visited[x][y]=false;
        sb.setLength(sb.length()-1);
    }
    boolean isSafe(int i, int j){
        return i>-1&&i<n&&j>-1&&j<m;
    }
    int dx[]={-1,0,0,1};
    int dy[]={0,-1,1,0};
    Set<String> ans;
    int n, m;
    boolean visited[][];
    Trie root;
    void insert(String s){
        char ch[]=s.toCharArray();
        int n=ch.length;
        Trie node = root;
        for(int i=0;i<n;i++){
            int ind = (int)(ch[i]-'a');
            if(node.child[ind]==null) node.child[ind]=new Trie();
            node=node.child[ind];
        }
        node.isWord=true;
    }
    boolean check(String s){
        char ch[]=s.toCharArray();
        int n=ch.length;
        Trie node = root;
        for(int i=0;i<n;i++){
            int ind = (int)(ch[i]-'a');
            if(node.child[ind]==null) return false;
            node=node.child[ind];
        }
        return node.isWord;
    }
    class Trie{
        Trie child[];
        boolean isWord;
        Trie(){
            child=new Trie[26];
            isWord=false;
        }
    }
}
