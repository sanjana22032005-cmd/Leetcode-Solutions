class Solution {
    
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int[] result=new int[n-k+1];
        int len=1;
        if(k==1){
            return nums;
        }
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]+1){
                len=1;
            }else{
                len++;
            }
            if(len>=k){
                result[i-k+1]=nums[i];
            }else if(i>=(k-1)){
                result[i-k+1]=-1;
            }
        }
        return result;
    }
}