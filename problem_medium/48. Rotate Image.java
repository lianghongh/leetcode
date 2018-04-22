class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null)
            return;
        int[][] temp=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                temp[j][matrix.length-i-1]=matrix[i][j];    //矩阵顺时针旋转90度坐标变换:(i,j)->(j,n-i-1)
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
                matrix[i][j]=temp[i][j];
        }
    }
}