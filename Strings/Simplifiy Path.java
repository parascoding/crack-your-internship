class Solution {
    public String simplifyPath(String S) {
        String s[]=S.split("/");
        Stack<String> st=new Stack<>();
        for(int i=0;i<s.length;i++){
            if(s[i].equals("..")&&!st.isEmpty()) st.pop();
            else if(!(s[i].equals("")||s[i].equals(".")||s[i].equals("..")))
                st.push(s[i]);
        }
        String ans="";
        while(!st.isEmpty()) ans="/"+st.pop()+ans;
        return ans.isEmpty()?"/":ans;
    }
}
