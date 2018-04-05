class Solution {
    public int nthUglyNumber(int n) {
        int[] num=new int[n];
        num[0]=1;
        int count2=0,count3=0,count5=0;
        for(int i=1;i<n;i++)
        {
            num[i]=Math.min(Math.min(num[count2]*2,num[count3]*3),num[count5]*5);
            if(num[i]==num[count2]*2)
                count2++;
            if(num[i]==num[count3]*3)
                count3++;
            if(num[i]==num[count5]*5)
                count5++;
        }
        return num[n-1];
    }
}