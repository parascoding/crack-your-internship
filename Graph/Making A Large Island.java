class Solution {
    public int largestIsland(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int max=1;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]==1)
                {
                    count=1;
                    dfs(a,i,j);
                    dfs2(a,i,j,count,i*m+j,hm,m);
                    max=Math.max(max,count);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]==0)
                {
                    
                    int temp=0;
                    HashSet<Integer> hs=new HashSet<Integer>();
                    for(int k=0;k<4;k++)
                    {
                        int xi=i+dx[k];
                        int xj=j+dy[k];
                        
                        if(isSafe(xi,xj,n,m)&&!hs.contains(hm.get(xi*m+xj)))
                        {
                            temp+=a[xi][xj];
                            hs.add(hm.get(xi*m+xj));
                        }
                        
                    }
                    max=Math.max(max,1+temp);

                }
            }
        }
        return max;
    }
    public int count=0;
    public int dx[]={-1,0,0,1};
    public int dy[]={0,-1,1,0};
    public void dfs2(int a[][],int i,int j,int size,int id,HashMap<Integer,Integer> hm,int m){
        a[i][j]=size;
        hm.put(i*m+j,id);
        for(int k=0;k<4;k++)
        {
            int xi=i+dx[k];
            int xj=j+dy[k];
            if(isSafe(xi,xj,a.length,a[0].length)&&a[xi][xj]==-1)
            {
                dfs2(a,xi,xj,size,id,hm,m);
            }
        }
    }
    public void dfs(int a[][],int i,int j){
        a[i][j]=-1;
        for(int k=0;k<4;k++)
        {
            int xi=i+dx[k];
            int xj=j+dy[k];
            if(isSafe(xi,xj,a.length,a[0].length)&&a[xi][xj]==1)
            {
                count++;
                dfs(a,xi,xj);
            }
        }
    }
    public boolean isSafe(int i,int j,int n,int m){
        return i>-1&&i<n&&j>-1&&j<m;
    }
}
