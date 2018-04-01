class Solution {
    public int trailingZeroes(int n) {
        int two=n;
        int two_sum=0,five_sum=0;
        while(n!=0)
        {
            n/=5;
            five_sum+=n;
        }
        while(two!=0)
        {
            two>>=1;
            two_sum+=two;
        }
        return two_sum<five_sum?two_sum:five_sum;
    }
}