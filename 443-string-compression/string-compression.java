class Solution {
    public int compress(char[] chars) {
       int i=0;
       int idx=0;
       while(i<chars.length){
        char curr=chars[i];
        int count=0;
        while(i<chars.length&&curr==chars[i]){
            count++;
            i++;
        }
        chars[idx++]=curr;
        if(count>1){
            int start=idx;
            while(count>0){
                chars[idx++]=(char)('0'+count%10);
                count/=10;
            }
            int left=start;
            int right=idx-1;
            while(left<right){
                char temp=chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
                left++;
                right--;
            }
            
        }
       }
       return idx;
    }
}