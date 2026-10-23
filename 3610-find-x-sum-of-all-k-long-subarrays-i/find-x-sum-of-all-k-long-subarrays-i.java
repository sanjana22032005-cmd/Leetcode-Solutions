class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=i;j<i+k;j++){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
            ArrayList<Integer> list=new ArrayList<>(map.keySet());
            Collections.sort(list,(a,b)->{
                if(!map.get(b).equals(map.get(a))){
                    return map.get(b)-map.get(a);
                }
                return b-a;
            });
            int sum=0;
            for(int j=0;j<Math.min(x,list.size());j++){
                int num=list.get(j);
                sum+=num*map.get(num);
            }
            ans[i]=sum;
        }
        return ans;
    }
}