public class Interview0803 {
    public int findMagicIndex(int[] nums) {
        if(nums.length == 0) return -1;
        int i = 0;
        while (true) {
            if (i >= nums.length) {
                i = -1;
                break;
            }
            if (nums[i] == i) {
                break;
            } else if (nums[i] > i) {
                i = nums[i];
            } else {
                i ++;
            }
        }
        return i;
    }
}
