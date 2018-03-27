class Solution {
    public int search(int[] nums, int target) {
        return search_p(nums, 0, nums.length - 1, target);
    }
    
    public int search_p(int[] nums, int l, int r, int target) {

        if (l<=r)
        {
            int mid = (l + r)/2;
            if (nums[mid] <= nums[r]) {
                if (target > nums[mid]&&target<=nums[r])
                    return binarySearch(nums, mid + 1, r+1, target);
                else if (target ==nums[mid])
                    return mid;
                else
                    return search_p(nums, l, mid - 1, target);
            } else {
                if (target < nums[mid]&&target>=nums[l]) {
                    return binarySearch(nums, l, mid , target);
                }
                else if (target == nums[mid])
                    return mid;
                else
                    return search_p(nums, mid + 1, r, target);
            }
        }
        return -1;
    }
    
    
    public int binarySearch(int[] nums, int from, int to, int target) {
        while (from<=to)
        {
            int m=(from+to)/2;
            if (target<nums[m])
                to=m-1;
            else if(target>nums[m])
                from=m+1;
            else
                return m;
        }
        return -1;
    }
}