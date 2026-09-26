class Solution {
    public void dfs(int[][] isConnected,boolean[] visit,int node){
        visit[node]=true;
        for(int next=0;next<isConnected.length;next++){
            if(isConnected[node][next]==1&&!visit[next]){
                dfs(isConnected,visit,next);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int provinces=0;
        boolean[] visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(isConnected,visit,i);
                provinces++;
            }
        }
        return provinces;
    }
}