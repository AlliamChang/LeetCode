public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int low = 0, high = nums.length;
        int mid = (high + low) / 2;
        int res = -1;
        while (res < 0) {
            if (mid == nums.length || target == nums[mid]) {
                res = mid;
            }else if(low == high){
                res = target < nums[mid]? mid:mid + 1;
            }else if(target < nums[mid]){
                high = mid;
                mid = (high + low) / 2;
            } else if (target > nums[mid]) {
                low = mid + 1;
                mid = (high + low) / 2;
            }
        }
        return res;
    }
}

