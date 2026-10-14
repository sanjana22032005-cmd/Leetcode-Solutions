class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1=new StringBuilder();
        StringBuilder t1=new StringBuilder();
        for(char ch:s.toCharArray()){

            if(ch=='#'){
                if(s1.length()>0){
                   s1.deleteCharAt(s1.length()-1);  
                }
            }else{
                s1.append(ch);
            }
        }
         for(char ch:t.toCharArray()){

            if(ch=='#'){
                if(t1.length()>0){
                   t1.deleteCharAt(t1.length()-1);  
                }
            }else{
                t1.append(ch);
            }
        }
        return  s1.toString().equals(t1.toString());

    }
}