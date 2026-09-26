class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length+1;
        List<List<Integer>> stargraph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            stargraph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            stargraph.get(u).add(v);
            stargraph.get(v).add(u);
        }
       for(int i=1;i<=n;i++){
            if(stargraph.get(i).size()==n-1){
                return i;
            }
       }
        return -1;
       
    }
}