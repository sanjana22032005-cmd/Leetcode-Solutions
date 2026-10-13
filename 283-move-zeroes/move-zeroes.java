class Solution {
    public void swap(int[] nums,int low,int high){
        int temp= nums[low];
        nums[low]=nums[high];
        nums[high]=temp;
    }
    public void moveZeroes(int[] nums) {
        int low=0;
        int high=0;
        while(high<nums.length){
            if(nums[high]!=0){
                swap(nums,low,high);
                low++;
            }
            high++;
              
        }
    }
}