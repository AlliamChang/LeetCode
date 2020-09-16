public class LeetCode201 {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        int tag = Integer.MIN_VALUE;
        while (tag != 0) {
            tag >>>= 1;
            if((m & tag) == (n & tag)){
                res |= m & tag;
            }else {
                break;
            }
        }
        return res;
    }
}
