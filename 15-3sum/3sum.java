class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int target=-nums[i];
             HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=i+1;j<n;j++){
                int complement=target-nums[j];
                if(map.containsKey(complement)){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(complement);
                    list.add(nums[j]);
                    Collections.sort(list);
                    ans.add(list);
                }
                map.put(nums[j],j);
            }
        }
        return new ArrayList<>(ans);
    }
}