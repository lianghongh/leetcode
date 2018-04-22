class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return r;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i==0||(i>0&&nums[i]!=nums[i-1]))
            {
                int l = i + 1, h = nums.length - 1;
                while (l < h) {
                    if (nums[l] + nums[h] + nums[i] == 0) {
                        r.add(new ArrayList<>(Arrays.asList(new Integer[]{nums[i], nums[l], nums[h]})));
                        while (l < h && nums[l] == nums[l + 1])
                            l++;
                        while (l < h && nums[h] == nums[h - 1])
                            h--;
                        l++;
                        h--;
                    } else if (nums[l] + nums[h] + nums[i] < 0)
                        l++;
                    else
                        h--;
                }
            }
        }
        return r;
    }
}