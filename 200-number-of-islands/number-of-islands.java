class Solution {
    public void dfs(char[][] grid,int i,int j,boolean[][] visit){
        visit[i][j]=true;
        int m=grid.length;
        int n=grid[0].length;
        int[] x={-1,1,0,0};
        int[] y={0,0,-1,1};
        for(int k=0;k<4;k++){
            int nr=i+x[k];
            int nc=j+y[k];
            if(nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]=='1'&&!visit[nr][nc]){
                dfs(grid,nr,nc,visit);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visit=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visit[i][j]=false;
            }
        }
      int res=0;
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]=='1'&&!visit[i][j]){
                dfs(grid,i,j,visit);
                res++;
            }
        }
      }
      return res;
    }
}