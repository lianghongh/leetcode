//解法一：dp，前一个数分为奇数和偶数讨论。如果
//第i-1个数是偶数，则第i个数1的位数为第i-1个数的个数+1
//如果是奇数则把第i-1个数右移一位，直到最后一位为0（偶数）,则第i个数1的位数为[第i-1个数1的个数]-[移动的位数]+1
class Solution {
    public int[] countBits(int num) {
        int[] result=new int[num+1];
        result[0]=0;
        for(int i=1;i<=num;i++)
        {
            if(((i-1)&1)==0)
                result[i]=result[i-1]+1;
            else
            {
                int count=0,t=i-1;
                while((t&1)==1)
                {
                    count++;
                    t>>=1;
                }
                result[i]=result[i-1]-count+1;
            }
        }
        return result;
    }
}

//解法二：把一个数分为最后一位和其他，则这个数1位数表示为除了最后一位的数表示的1的个数加上最后一位。

class Solution{
    public int[] countBits(int num){
        int[] result=new int[num+1];
        for(int i=1;i<=num;i++)
            result[i]=result[i>>1]+(i&1);
        return result;
    }
}