class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1)
            return false;
        while(n>1)
        {
            if((n&1)==0)
                n>>=1;
            else
                return false;
        }
        return true;
    }
}