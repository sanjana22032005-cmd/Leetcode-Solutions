class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result=new long[k];
        long[] dp=new long[k];
        for(int num:nums){
            long[] newdp=new long[k];
            int rem=num%k;
            newdp[rem]++;
            for(int r=0;r<k;r++){
                int newr=(r*rem)%k;
                newdp[newr]+=dp[r];
            }
            for(int r=0;r<k;r++){
                result[r]+=newdp[r];
            }
            dp=newdp;
        }
        return result;
    }
}