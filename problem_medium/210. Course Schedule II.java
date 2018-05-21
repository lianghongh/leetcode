//拓扑排序
//算法一：Kahn算法：每次删除入度为0的点，直到所有点被删除。如果有点没有被删除，说明有环。
//算法二：DFS
class Solution {
    //Kahn算法求拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in_degree=new int[numCourses];
        int[] result=new int[numCourses];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<prerequisites.length;i++)
            in_degree[prerequisites[i][0]]++;
        for(int i=0;i<in_degree.length;i++)
        {
            if(in_degree[i]==0)
                s.push(i);
        }
        
        int count=0;
        while(!s.isEmpty())
        {
            result[count++]=s.pop();
            for(int i=0;i<prerequisites.length;i++)
            {
                if(prerequisites[i][1]==result[count-1]&&--in_degree[prerequisites[i][0]]==0)
                    s.push(prerequisites[i][0]);
            }
        }
        if(count==numCourses)
            return result;
        else
            return new int[0];
    }
}