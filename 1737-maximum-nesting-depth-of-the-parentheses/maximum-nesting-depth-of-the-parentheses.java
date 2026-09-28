class Solution {
    public int maxDepth(String s) {
        int curr=-1;
        int max=-1;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='('){
            curr++;

           }else if(s.charAt(i)==')'){
            curr--;
           }else{
            continue;
           }
           max=Math.max(curr,max);
        }
        return max+1;
    }
}