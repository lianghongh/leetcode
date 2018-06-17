class NumArray {

    private int[] nums;
    private int[] sum;
    
    public NumArray(int[] nums) {
        this.nums=nums;
        sum=new int[nums.length<<2];
        build(0,0,nums.length-1);
    }
    
    public void update(int i, int val) {
        push_down(0,0,nums.length-1,i,val);
    }
    
    public int sumRange(int i, int j) {
        return search(i,j,0,nums.length-1,0);
    }
    
    private void build(int root,int l,int r)
    {
        if(l>r)
            return;
        if(l==r)
        {
            sum[root]=nums[l];
            return;
        }
        
        int m=(l+r)>>1;
        build(root*2+1,l,m);
        build(root*2+2,m+1,r);
        sum[root]=sum[root*2+1]+sum[root*2+2];
    }
    
    private int search(int L,int R,int l,int r,int root)
    {
        if(L<=l&&r<=R)
            return sum[root];
        
        int m=(l+r)>>1;
        int ans=0;
        if(L<=m)
            ans+=search(L,R,l,m,root*2+1);
        if(R>m)
            ans+=search(L,R,m+1,r,root*2+2);
        return ans;
    }
    
    public void push_down(int root,int l,int r,int i,int val)
    {
        if(l==r)
        {
            sum[root]=val;
            return;
        }
        
        int m=(l+r)>>1;
        if(i<=m)
        {
            sum[root]-=sum[root*2+1];
            push_down(root*2+1,l,m,i,val);
            sum[root]+=sum[root*2+1];
        }
        else
        {
            sum[root]-=sum[root*2+2];
            push_down(root*2+2,m+1,r,i,val);
            sum[root]+=sum[root*2+2];
        }
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */