class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:dislikes){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] colors=new int[n+1];
        Arrays.fill(colors,-1);
        for(int i=1;i<=n;i++){
            if(colors[i]!=-1){
                continue;
            }
            Queue<Integer> q=new LinkedList<>();
            q.offer(i);
            colors[i]=0;
            while(!q.isEmpty()){
                int node=q.poll();
                for(int next:adj.get(node)){
                    if(colors[next]==-1){
                        colors[next]=1-colors[node];
                        q.offer(next);
                    }else if(colors[node]==colors[next]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}