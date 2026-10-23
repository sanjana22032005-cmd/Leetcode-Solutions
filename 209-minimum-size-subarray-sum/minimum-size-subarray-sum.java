class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int left=0;
        int len=Integer.MAX_VALUE;
        int sum=0;
        for(int right=0;right<n;right++){
           sum+=nums[right];
           while(sum>=target){
            len=Math.min(right-left+1,len);
            sum-=nums[left];
            left++;
           }
        }
        if(len==Integer.MAX_VALUE){
            return 0;
        }else{
            return len;
        }
    }
}