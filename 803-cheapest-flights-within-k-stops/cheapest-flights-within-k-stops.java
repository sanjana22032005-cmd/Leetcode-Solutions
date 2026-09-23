class Solution {class pair{
    int to;
    int price;
    pair(int t,int p){
        to=t;
        price=p;
    }
}
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:flights){
          int from=edge[0];
          int to=edge[1];
          int price=edge[2];
          adj.get(from).add(new pair(to,price));
        }
        int[][] dist=new int[n][k+2];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{src,0,0});
        dist[src][0]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int from=curr[0];
            int price=curr[1];
            int stops=curr[2];
            if(from==dst){
                return price;
            }
            if(stops>k){
                continue;
            }
            for(pair next:adj.get(from)){
                int newp=price+next.price;
                int news=stops+1;
                if(newp<dist[next.to][news]){
                    dist[next.to][news]=newp;
                    pq.offer(new int[]{next.to,newp,news});
                }
            }
        }
    return -1;
}
}