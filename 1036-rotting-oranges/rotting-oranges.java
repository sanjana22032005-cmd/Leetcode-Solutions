class Solution {
    class pair{
        int fir;
        int sec;
        pair(int first,int second){
            fir=first;
            sec=second;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        int fres=0;
        int time=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j));
                    grid[i][j]=-2;

                }else if(grid[i][j]==1){
                    fres++;
                }
            }
        }
        while(!q.isEmpty()&&fres>0){
            time++;
            int si=q.size();
            while(si-->0){
                pair curr=q.poll();
                int f=curr.fir;
                int s=curr.sec;
                int[] x={-1,1,0,0};
                int[] y={0,0,-1,1};
                for(int k=0;k<4;k++){
                    int nr=f+x[k];
                    int nc=s+y[k];
                    if(nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]==1){
                        q.offer(new pair(nr,nc));
                        grid[nr][nc]=-2;
                        fres--;
                    }
                }
            }
           

        }
        if(fres>0){
            return -1;
        }else{
            return time;
        }

    }
}