class Solution {
    public List<String> generateParenthesis(int n) {
        int left=n,right=n;
        List<String> result=new ArrayList<>();
        generate(result,left,right,"");
        return result;
    }
    
    public void generate(List<String> r,int left,int right,String buffer) {
        if (left<0||right<0||left>right)
            return;
        if (left==0&&right==0)
        {
            r.add(buffer);
            return;
        }
        generate(r,left-1,right,buffer+"(");
        generate(r,left,right-1,buffer+")");
    }
}
