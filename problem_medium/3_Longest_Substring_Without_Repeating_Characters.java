class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int len=0,l=0,r=0;
        while (l < s.length() && r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
                len=r-l>len?r-l:len;
            }
            else
                set.remove(s.charAt(l++));
        }
        return len;
    }
}