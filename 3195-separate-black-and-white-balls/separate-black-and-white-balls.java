class Solution {
    public long minimumSteps(String s) {
       int low=0;
       long steps=0;
       for(int high=0;high<s.length();high++){
        if(s.charAt(high)=='0'){
            steps+=high-low;
            low++;
        }
       } 
       return steps;

    }
}