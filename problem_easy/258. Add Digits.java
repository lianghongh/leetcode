class Solution {
    public int addDigits(int num) {
        while(num>=10)
        {
            int sum=0;
            for(int i=num;i>0;)
            {
                sum+=i%10;
                i/=10;
            }
            num=sum;
        }
        return num;
    }
}