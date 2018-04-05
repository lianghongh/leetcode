class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l=new ArrayList<>();
        if(nums==null||nums.length==0)
            return l;
        int c1=nums[0],c2=nums[0],count1=0,count2=0;   //投票算法，由于题目要求重复次数大于n/3，因此这样的数不会超过两个。可以定义两个候选人c1和c2以及他们的票数
        for(int i=0;i<nums.length;i++)                 //count1和count2。当数组中的元素等于c1或c2时使其count++，表示投票；都不相同时检查是否有人票数为0   
        {                                             
            if(c1==nums[i])
                count1++;
            else if(c2==nums[i])
                count2++;
            else if(count1==0)                         //都不同时检查是否有人票数为0，如果有则替换掉该候选者，票数置为1
            {
                c1=nums[i];
                count1=1;
            }
            else if(count2==0)
            {
                c2=nums[i];
                count2=1;
            }
            else                                       //不同且两个人都有票数时票数同时-1，票数越多的人会留存到最后
            {
                count1--;
                count2--;
            }
        }                                              //最终c1和c2表示票数最多的两个人
        count1=count2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(c1==nums[i])
                count1++;
            else if(c2==nums[i])
                count2++;
        }
        if(count1>nums.length/3)                      //检查得票数最多的人的票数是否大于n/3，是则添加到结果中
            l.add(c1);
        if(count2>nums.length/3)
            l.add(c2);
        return l;
    }
}