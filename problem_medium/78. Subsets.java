//方法一：dfs
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        boolean[] mask=new boolean[nums.length];
        List<List<Integer>> r = new ArrayList<>();
        dfs(nums,0,mask,r);
        return r;
    }
    
    public void dfs(int[] nums,int cur,boolean[] mask,List<List<Integer>> result)
    {
        if(cur>=mask.length)
        {
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<mask.length;i++)
            {
                if (mask[i])
                    l.add(nums[i]);
            }
            result.add(l);
            return;
        }
        mask[cur]=true;
        dfs(nums,cur+1,mask,result);
        mask[cur]=false;
        dfs(nums,cur+1,mask,result);
    }
}

//方法二：模拟二进制加法

class Solution{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> lists = new ArrayList<>();
        int bit=0,len=pow(2,nums.length);
        for(int i=0;i<len;i++,bit++)
        {
            int j=0,s=bit;
            List<Integer> l = new ArrayList<>();
            while (s>0)
            {
                if((s&1)==1)
                    l.add(nums[j]);
                s>>=1;
                j++;
            }
            lists.add(l);
        }
        return lists;
    }

    
    public int pow(int n,int m)
    {
        int s=1;
        for(int i=0;i<m;i++)
            s*=n;
        return s;
    }
}