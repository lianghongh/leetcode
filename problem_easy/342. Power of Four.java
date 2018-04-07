class Solution {
    public boolean isPowerOfFour(int num) {
        int count=0;
        if(num==0)
            return false;
        while((num&1)==0)
        {
            num>>=1;
            count++;
        }
        if(num==1&&count%2==0)
            return true;
        return false;
    }
}