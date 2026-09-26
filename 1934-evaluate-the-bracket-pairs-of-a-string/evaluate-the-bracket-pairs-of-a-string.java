class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        int n=knowledge.size();
        for(int i=0;i<n;i++){
            int j=0;
            String key=knowledge.get(i).get(j);
            String value=knowledge.get(i).get(j+1);
            map.put(key,value);
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int start=-1;
            int end=-1;
            if(s.charAt(i)=='('){ 
                start=i; 
                for(int j=i+1;j<s.length();j++){ 
                    if(s.charAt(j)==')'){ 
                        end=j; 
                        break; 
                    } 
                } 
                String str=s.substring(start+1,end); 
                if(map.containsKey(str)){ 
                    String value=map.get(str); 
                    result.append(value); 
                }
                else{ 
                    result.append('?'); 
                } 
                i=end; 
            }
            else{
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}