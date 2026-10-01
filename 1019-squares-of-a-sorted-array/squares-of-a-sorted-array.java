class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sq=new int[nums.length];
        int n=nums.length;
        for(int i=0;i<n;i++){
            sq[i]=nums[i]*nums[i];
        }
        Arrays.sort(sq);
        return sq;
    }
}