class Solution {
    public void swap(int[] nums,int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public int[] sortArrayByParity(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            if(nums[low]%2==0){
                low++;
            }else if(nums[high]%2==0){
                swap(nums,low,high);
                low++;
                high--;
            }else{
                high--;
            }
        }
        return nums;
    }
}