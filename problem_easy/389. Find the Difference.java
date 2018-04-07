class Solution {
    public char findTheDifference(String s, String t) {
        int result=0;
        for(int i=0;i<s.length();i++)                     //把每个字母转换成数字，对所有数做异或运算就能得到多出来的那个数
            result^=s.charAt(i)-'a';
        for(int i=0;i<t.length();i++)
            result^=t.charAt(i)-'a';
        return (char)('a'+result);
    }
}