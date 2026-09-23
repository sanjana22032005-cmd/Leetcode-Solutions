class Solution {
    public int minOperations(int[] nums, int x) {
       int n=nums.length;
       int totalsum=0;
       for(int num:nums){
        totalsum+=num;
       }
       int target=totalsum-x;
       if(target<0){
        return -1;
       }
       if(target==0){
        return n;
       }
       int left=0;
       int sum=0;
       int maxlen=-1;
       for(int right=0;right<n;right++){
            sum+=nums[right];
            while(sum>target&&left<=right){
                sum-=nums[left];
                left++;
            }
            if(sum==target){
                maxlen=Math.max(maxlen,right-left+1);
            }
       }
       return maxlen==-1?-1:n-maxlen;
    }
}