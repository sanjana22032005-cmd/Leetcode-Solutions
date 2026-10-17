class Solution {
    public String reverseWords(String s) {
        StringBuilder st=new StringBuilder();
        String[] words=s.split(" ");
        for(int i=words.length-1;i>=0;i--){
            if(!words[i].isEmpty()){
                st.append(words[i]);
                st.append(" ");
            }
        }
        return st.toString().trim();
    }
}