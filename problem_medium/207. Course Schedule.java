//拓扑排序，判断图是否有环
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in_degree=new int[numCourses];
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
            int n=s.pop();
            for(int i=0;i<prerequisites.length;i++)
            {
                if(prerequisites[i][1]==n&&--in_degree[prerequisites[i][0]]==0)
                    s.push(prerequisites[i][0]);
            }
            count++;
        }
        if(count==numCourses)
            return true;
        return false;
    }
}