class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1)
            return "";
        if(strs.length==1)
            return strs[0];
        String prefix = longStringPre(strs[0], strs[1]);
        for(int i=2;i<strs.length;i++) {
            prefix = longStringPre(prefix, strs[i]);
        }
        return prefix;
    }
    
    public String longStringPre(String s1, String s2) {
        int i;
        for(i=0;i<s1.length()&&i<s2.length();i++) {
            if(s1.charAt(i)!=s2.charAt(i))
                break;
        }
        return s1.substring(0, i);
    }
}