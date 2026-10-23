class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[128];
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }
        int minLen=Integer.MAX_VALUE;
        int left=0;
        int start=0;
        int ct=t.length();
        for(int right=0;right<s.length();right++){
           char ch=s.charAt(right);
           if(freq[ch]>0){
            ct--;
           }
           freq[ch]--;
           while(ct==0){
            if(right-left+1<minLen){
               minLen=right-left+1;
               start=left;
            }
            char l=s.charAt(left);
            freq[l]++;
            if(freq[l]>0){
                ct++;
            }
            left++;
           }
        }
        if(minLen==Integer.MAX_VALUE){
            return "";
        }else{
            return s.substring(start,start+minLen);
        }
    }
}