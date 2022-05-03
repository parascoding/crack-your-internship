class Solution {
    public boolean exist(char[][] a, String s) {
        n=a.length; m=a[0].length;
        visited=new boolean[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(a[i][j]==s.charAt(0)&&dfs(a,i,j,0,s))
                    return true;
        return false;
    }
    boolean dfs(char a[][],int i, int j, int ind, String s){
        if(ind==s.length()-1)
            return true;
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int xi=i+dx[k];int xj=j+dy[k];
            if(isSafe(xi,xj)&&!visited[xi][xj]&&a[xi][xj]==s.charAt(ind+1)&&dfs(a,xi,xj,ind+1,s))
                return true;
        }
        return visited[i][j]=false;
    }
    boolean isSafe(int i, int j){
        return i>-1&&i<n&&j>-1&&j<m;
    }
    int dx[]={-1,0,0,1};
    int dy[]={0,-1,1,0};
    int n,m;
    boolean visited[][];
    
}
