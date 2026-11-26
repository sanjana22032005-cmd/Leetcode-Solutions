class Solution {
    class pair{
        int num;
        int freq;
        pair(int n,int f){
            freq=f;
            num=n;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.freq-b.freq);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key:map.keySet()){
            pq.offer(new pair(key,map.get(key)));
            while(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans=new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=pq.poll().num;
        }
        return ans;
    }
}