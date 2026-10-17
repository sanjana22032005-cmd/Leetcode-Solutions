class Solution {
    public boolean vowels(char c){
        if(c=='a'||c=='A'||c=='e'||c=='E'||c=='i'||c=='I'||c=='o'||c=='O'||c=='u'||c=='U'){
            return true;
        }else{
            return false;
        }
    }
    public String reverseVowels(String s) {
       char[] a=s.toCharArray();
       int i=0;
       int j=a.length-1;
       while(i<j){
          while(i<j&&!vowels(a[i])) i++;
          while(i<j&&!vowels(a[j])) j--;

          char temp=a[i];
          a[i]=a[j];
          a[j]=temp;
          i++;
          j--;
       }
       return  new String(a);
    }
}