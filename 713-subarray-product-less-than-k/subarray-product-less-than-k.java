class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int low=0;
        int count=0;
        int prdt=1;
        if(k<=1){
            return 0;
        }
        for(int high=0;high<nums.length;high++){
            prdt=prdt*nums[high];
            while(prdt>=k){
                prdt=prdt/nums[low];
                low++;
            }
            count+=(high-low)+1;
        }
        return count;
    }
}