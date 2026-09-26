class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int per=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    per+=4;
                     int[] x={-1,1,0,0};
                int[] y={0,0,-1,1};
                for(int k=0;k<4;k++){
                    int nr=i+x[k];
                    int nc=j+y[k];
                    if(nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]==1){
                        per--;
                    }
                }
                }
            }
        }
        return per;
    }
}