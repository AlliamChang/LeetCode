import java.util.*;

public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> col = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                len --;
                TreeNode node = queue.pollFirst();
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
                col.add(node.val);
            }
            res.add(0, col);
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] preOrder = {33,15,35,43,41,42,4,23,37,25,29,20,36,2,11,17,31,40,6,19,7,8,22,28,12,24,32,1,9,10,21,14,18,26,5,34,16,3,13,38,27,30,39};
//        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        int[] inOrder = {41,42,43,35,23,4,29,25,37,20,15,40,31,17,11,2,19,8,7,6,22,36,33,12,32,1,14,21,10,18,9,34,5,26,24,13,3,38,16,28,30,27,39};
        new LeetCode107().findOrder(preOrder, inOrder);
    }

//    private int i = 0;
    private int k = 0;
    public int[] findOrder (int[] preOrder, int[] inOrder) {
        // write code here
        int[] res = new int[preOrder.length];
        find(preOrder, inOrder, res, 0, preOrder.length - 1, 0, inOrder.length - 1);
        return res;
    }

    public void find(int[] preOrder, int[] inOrder, int[] res, int preLeft, int preRight, int inLeft, int inRight){
        if(inLeft > inRight) return;
        if(preLeft == preRight){
            res[k++] = preOrder[preLeft];
            return;
        }
        int target = preOrder[preLeft];
        int j = inLeft;
        while(j <= inRight){
            if(inOrder[j] == target){
                break;
            }
            j ++;
        }
        int leftLen = j - inLeft;
        int rightLen = inRight - j;
        find(preOrder, inOrder, res, preLeft + 1, preLeft + leftLen, inLeft, j - 1);
        find(preOrder, inOrder, res, preRight - rightLen + 1, preRight, j + 1, inRight);
        res[k++] = target;
    }
}
