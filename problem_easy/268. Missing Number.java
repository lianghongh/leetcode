//方法一：求和
//计算0-n的和以及nums所有元素的和，求差即可得到结果
class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i:nums)
            sum+=i;
        return n*(n+1)/2-sum;
    }
}

//方法二：使用异或运算
//异或运算满足a^b=b^a   (a^b)^c=a^(b^c)，因此可以把0-n和nums中的数表示为：
//0 1 2 3 4 ... n n-1
//0 1 2 miss 4 5 ... n n-1
//由于a^a=0且a^0=a，因此全部进行异或运算即可达到缺失的数
class Solution {
    public int missingNumber(int[] nums) {
        int miss=nums.length;
        for(int i=0;i<nums.length;i++)
            miss^=i^nums[i];
        return miss;
    }
}