class Solution {
    class pair{
        int node;
        int time;
        pair(int n,int t){
            node=n;
            time=t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:times){
            int src=edge[0];
            int dest=edge[1];
            int time=edge[2];
            adj.get(src).add(new pair(dest,time));
        }
        int[] res=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        pq.offer(new pair(k,0));
        res[k]=0;
        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int dest=curr.node;
            int t=curr.time;
            if(t>res[dest]){
                continue;
            }
            for(int j=0;j<adj.get(dest).size();j++){
                pair neig=adj.get(dest).get(j);
                int next=neig.node;
                int ti=neig.time;
                if(ti+t<res[next]){
                    res[next]=ti+t;
                    pq.offer(new pair(next,ti+t));
                }
            }
        }
        int min=0;
        for(int i=1;i<=n;i++){
            if(res[i]==Integer.MAX_VALUE){
                return -1;
            }else{
                min=Math.max(min,res[i]);
            }
        }
        return min;

    }
}