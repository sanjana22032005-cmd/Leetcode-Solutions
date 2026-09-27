class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=numCourses;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(int[] edge:prerequisites){
            int u=edge[0];
            int v=edge[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
              q.offer(i);
            }
        }
        int[] res=new int[n];
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            res[i]=node;
            i++;
            for(int j=0;j<adj.get(node).size();j++){
                int next=adj.get(node).get(j);
                indegree[next]--;
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
        if(i!=numCourses){
            return new int[0];
        }else {
            return res;
        }
    }
}