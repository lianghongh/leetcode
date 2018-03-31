class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] sum=new int[triangle.size()][];
        for(int i=0;i<triangle.size();i++)
            sum[i]=new int[triangle.get(i).size()];
        for(int i=0;i<triangle.size();i++)
            sum[triangle.size()-1][i]=triangle.get(triangle.size()-1).get(i);
        for(int i=triangle.size()-2;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
                sum[i][j]=triangle.get(i).get(j)+(sum[i+1][j]<sum[i+1][j+1]?sum[i+1][j]:sum[i+1][j+1]);
        }
        return sum[0][0];
    }
}