class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        s.add(n);
        while (true)
        {
            int sum=0;
            for(;n!=0;)
            {
                sum+=(n%10)*(n%10);
                n/=10;
            }
            if(sum==1)
                return true;
            else if(s.contains(sum))
                return false;
            else
                s.add(sum);
            n=sum;
        }
    }
}