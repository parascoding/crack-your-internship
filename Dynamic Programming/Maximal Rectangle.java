class Solution {
    public int maximalRectangle(char[][] mat) {
        int n=mat.length, m=mat[0].length;
        int a[]=new int[m];
        for(int j=0;j<m;j++) a[j]=mat[0][j]-'0';
        int max=find(a,m);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]=='0') a[j]=0;
                else a[j]++;
            }
            max=Math.max(max, find(a,m));
        }
        return max;
    }
    int find(int a[], int n){
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=-1;
        right[n-1]=n;
        for(int i=1;i<n;i++){
            int p=i-1;
            while(p>-1&&a[p]>=a[i])
                p=left[p];
            left[i]=p;
        }
        for(int i=n-2;i>-1;i--){
            int p=i+1;
            while(p<n&&a[p]>=a[i])
                p=right[p];
            right[i]=p;
        }
        int max=0;
        for(int i=0;i<n;i++)
            max=Math.max(max, a[i]*(right[i]-left[i]-1));
        return max;
    }
}
