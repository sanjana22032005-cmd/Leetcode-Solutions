class Solution {
    public boolean dfs(List<List<Integer>> adj,int[] state,int i){
        if(state[i]==1){
            return true;
        }
        if(state[i]==2){
            return false;
        }
        state[i]=1;
        for(int next:adj.get(i)){
            if(dfs(adj,state,next)){
                return true;
            }
        }
        state[i]=2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge:prerequisites){
            int course=edge[0];
            int prereq=edge[1];
            adj.get(course).add(prereq);
        }
        int[] state=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(state[i]==0){
                if(dfs(adj,state,i)){
                    return false;
                }
            }
        }
        return true;

    }
}