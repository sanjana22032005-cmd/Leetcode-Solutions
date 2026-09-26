class Solution {
    public void dfs(List<List<Integer>> adj,boolean[] visit,int source){
        visit[source]=true;
        for(int next:adj.get(source)){
            if(!visit[next]){
                dfs(adj,visit,next);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[]visit=new boolean[n];
        Arrays.fill(visit,false);
        dfs(adj,visit,source);
        if(visit[destination]){
            return true;
        }else{
            return false;
        }

    }
}