class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null)
            return false;
        int i=matrix.length-1;              //和matrix[n-1][0]比较，n为矩阵的行数
        int j=0;
        while(i>=0&&j<matrix[0].length)
        {
            if(matrix[i][j]>target)
                i--;
            else if(matrix[i][j]<target)
                j++;
            else
                return true;
        }
        return false;
    }
}