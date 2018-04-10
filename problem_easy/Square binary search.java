/*解法一：二分搜索：每次把矩阵横竖切成2块，取切线的交点，分别对交点所在的行和列做二分搜索。找到返回数的坐标
如果没有找到，则比较target与交点的大小，如果小于交点，则搜索左上角的子矩阵，否则继续搜索右边的三块矩阵
*/

/*
解法二：从矩阵的左下角开始搜索，比较目标值与该点的大小。如果比该点的值大，则右移一格，否则上移一格。
越界表明没找到该元素
*/

 class Point
    {
        public int x,y;
        public Point(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }

    public Point search(int[][] matrix,int start_x,int start_y,int m,int n,int target)
    {
        if(m==0||n==0)
            return new Point(-1,-1);
        int m1=m/2;
        int n1=n/2;
        Point p=binaryColSearch(matrix,start_x+m1,start_y+n1,start_x,start_x+m-1,target,false);
        if(p.x!=-1)
            return p;
        p=binaryColSearch(matrix,start_x+m1,start_y+n1,start_y,start_y+n-1,target,true);
        if(p.y!=-1)
            return p;
        if(matrix[m1][n1]>target)
            return search(matrix,start_x,start_y,m1,n1,target);
        else
        {
            p=search(matrix,start_x,start_y+n1+1,m-m1-1,n-n1-1,target);
            if(p.x!=-1)
                return p;
            p=search(matrix,start_x+m1+1,start_y,m-m1-1,n-n1-1,target);
            if(p.x!=-1)
                return p;
            return search(matrix,start_x+m1+1,start_y+n1+1,m-m1-1,n-n1-1,target);
        }
    }

    public Point binaryColSearch(int[][] martix,int x,int y,int l,int r,int target,boolean isCol)
    {
        if(martix[x][y]==target)
            return new Point(x+1,y+1);
        if(isCol)
        {
            while (l<=r)
            {
                int m=(l+r)>>1;
                if(martix[x][m]>target)
                    r=m-1;
                else if(martix[x][m]<target)
                    l=m+1;
                else
                    return new Point(x+1,m+1);
            }
        }
        else
        {
            while (l<=r)
            {
                int m=(l+r)>>1;
                if(martix[m][y]>target)
                    r=m-1;
                else if(martix[m][y]<target)
                    l=m+1;
                else
                    return new Point(m+1,y+1);
            }
        }
        return new Point(-1,-1);
    }