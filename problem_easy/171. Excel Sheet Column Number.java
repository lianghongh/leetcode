class Solution {
    public int titleToNumber(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            int d=s.charAt(i)-'A'+1;
            sum+=d*Math.pow(26,s.length()-i-1);
        }
        return sum;
    }
}