class Solution {
    public List<List<String>> solveNQueens(int n) {
        ch=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                ch[i][j]='.';
        ans=new ArrayList<>();
        solve(n,0);
        return ans;
    }
    private void solve(int n,int row){
        if(n==row)
        {
            ans.add(new ArrayList<>(build(n)));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(row,i,n))
            {
                ch[row][i]='Q';
                solve(n,row+1);
                ch[row][i]='.';
            }
        }
    }
    private ArrayList<String> build(int n){
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(new String(ch[i]));
        }
        return list;
    } 
    private boolean isSafe(int row,int col,int n){
        for(int i=row;i>-1;i--)
            if(ch[i][col]=='Q') 
                return false;
        for(int i=row,j=col;i>-1&&j>-1;j--,i--)
            if(ch[i][j]=='Q')
                return false;
        for(int i=row,j=col;i>-1&&j<n;j++,i--)
            if(ch[i][j]=='Q')
                return false;
        return true;
    }
    private List<List<String>> ans;
    private char ch[][];
}
