class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n=nums.length;
        int left=0;
        int ct=0;
        ArrayDeque<Integer> min=new ArrayDeque<>();
        ArrayDeque<Integer> max=new ArrayDeque<>();
        for(int right=0;right<n;right++){
           while(!min.isEmpty()&&nums[min.peekLast()]>nums[right]){
            min.pollLast();
           }
           while(!max.isEmpty()&&nums[max.peekLast()]<nums[right]){
            max.pollLast();
           }
           min.offerLast(right);
           max.offerLast(right);
           while(nums[max.peekFirst()]-nums[min.peekFirst()]>limit){
            if(min.peekFirst()==left){
                min.pollFirst();
            }
            if(max.peekFirst()==left){
                max.pollFirst();
            }
            left++;
           }
            ct=Math.max(ct,right-left+1);
        }
        return ct;
    }
}