class Solution {
    public void dfs(List<List<Integer>> rooms,int node,boolean[] unlocked){
        unlocked[node]=true;
        for(int next:rooms.get(node)){
            if(!unlocked[next]){
                dfs(rooms,next,unlocked);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] unlocked=new boolean[n];
        dfs(rooms,0,unlocked);
        for(int i=1;i<n;i++){
            if(!unlocked[i]){
                return false;
            }
        }
        return true;
    }
}