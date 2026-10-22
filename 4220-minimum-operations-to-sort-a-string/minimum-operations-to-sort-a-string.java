class Solution {
    public boolean isSorted(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<s.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
    public int minOperations(String s) {
        int n=s.length();
        if(isSorted(s)){
            return 0;
        }
        if(n==2){
            return -1;
        }
        char mn='z';
        char mx='a';

        for(char ch:s.toCharArray()){
            mn=(char)Math.min(ch,mn);
            mx=(char)Math.max(ch,mx);
        }
        if(mn==s.charAt(0)||mx==s.charAt(n-1)){
            return 1;
        }
        for(int i=1;i<n-1;i++){
            if(s.charAt(i)==mn||s.charAt(i)==mx){
                return 2;
            }
        }
        return 3;

    }
}