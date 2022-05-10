class Solution {
    public int swimInWater(int[][] a) {
        int n=a.length;
        // int m=a[0].length;
        int low=0,high=n*n;
        return find(a,low,high,n);
    }
    public int find(int a[][],int low,int high,int n){
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(check(a,mid,n))
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
    public boolean check(int a[][],int mid,int n){
        boolean visited[][]=new boolean[n][n];
        Queue<Node> q=new LinkedList<Node>();
        if(a[0][0]>mid) return false;
        q.add(new Node(0,0));
        int dx[]={-1,0,0,1};
        int dy[]={0,-1,1,0};
        
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            int i=temp.i;
            int j=temp.j;
            if(i==n-1&&j==n-1) return true;
            for(int k=0;k<4;k++)
            {
                int xi=i+dx[k];
                int xj=j+dy[k];
                if(isSafe(xi,xj,n)&&a[xi][xj]<=mid&&!visited[xi][xj])
                {
                    q.add(new Node(xi,xj));
                    visited[xi][xj]=true;
                }
            }
        }
        return false;
    }
    public boolean isSafe(int i,int j,int n){
        return i>-1&&i<n&&j>-1&&j<n;
    }
    static class Node{
        int i;
        int j;
        Node(int x,int y){
            i=x;
            j=y;
        }
    }
}
