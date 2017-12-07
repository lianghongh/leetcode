class Solution:
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        k=len(nums)-2
        while k>=0 and nums[k]>=nums[k+1]:
            k=k-1
        if k==-1:
            nums.reverse()
            return
        i=len(nums)-1
        while i>k and nums[i]<=nums[k]:
            i=i-1
        nums[i],nums[k]=nums[k],nums[i]
        temp=nums[:]
        nums.clear()
        nums.extend(temp[:k+1])
        nums.extend(temp[:k:-1])