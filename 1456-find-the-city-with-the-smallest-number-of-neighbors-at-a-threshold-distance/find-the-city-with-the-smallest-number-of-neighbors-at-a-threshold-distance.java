class Solution {
    class pair{
        int to;
        int weight;
        pair(int t,int we){
            to=t;
            weight=we;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:edges){
            int from=edge[0];
            int to=edge[1];
            int weight=edge[2];
            adj.get(from).add(new pair(to,weight));
            adj.get(to).add(new pair(from,weight));
        }
       int ans=-1;
       int mincity=Integer.MAX_VALUE;
       for(int src=0;src<n;src++){
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{src,0});
        dist[src]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int currd=curr[1];
            if(currd>dist[node]){
                continue;
            }
            for(pair next:adj.get(node)){
                int edge=next.to;
                int newD=next.weight+currd;
                if(newD<dist[edge]&&newD<=distanceThreshold){
                    dist[edge]=newD;
                    pq.offer(new int[]{edge,newD});
                }
                

            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(i!=src&&dist[i]<=distanceThreshold){
                count++;
            }
        }
        if(count<=mincity){
            mincity=count;
            ans=src;
        }
       }
      return ans;

  
    }
}