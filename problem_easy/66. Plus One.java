class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0)
            return null;
        int c=1;
        int[] pp=new int[digits.length+1];
        for(int i=digits.length-1;i>=0;i--)
        {
            int s=digits[i]+c;
            c=s/10;
            digits[i]=s%10;
            pp[i+1]=digits[i];
        }
        if(c==0)
            return digits;
        else
        {
            pp[0]=1;
            return pp;
        }
    }
}