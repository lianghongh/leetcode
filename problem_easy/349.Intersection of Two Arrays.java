class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int i:nums1)
            s1.add(i);
        for(int i:nums2)
            s2.add(i);
        s1.retainAll(s2);
        Integer[] result=new Integer[s1.size()];
        s1.toArray(result);
        int[] r=new int[result.length];
        for(int i=0;i<result.length;i++)
            r[i]=result[i];
        return r;
    }
}