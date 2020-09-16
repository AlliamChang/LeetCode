import java.util.Arrays;

public class LeetCode215 {
    public static void main(String[] args){
        int[] nums =     {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        new LeetCode215().findKthLargest(nums, 20);
    }

    public int findKthLargest(int[] nums, int k) {
        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
                topk[i] = nums[i];
        }
        minHeap(topk);
        for (int i = k; i < nums.length; i++) {
            if(nums[i] > topk[0]) {
                topk[0] = nums[i];
                shiftDown(topk, 0);
            }
        }
        return topk[0];
    }

    private void minHeap(int[] heap) {
        for (int i = (heap.length / 2) - 1; i >= 0; i--) {
            shiftDown(heap, i);
        }
    }

    private void shiftDown(int[] heap, int i){
        int next = i;
        if (i * 2 + 1 < heap.length && heap[i * 2 + 1] < heap[i]) {
            next = i * 2 + 1;
        }
        if (i * 2 + 2 < heap.length && heap[i * 2 + 2] < heap[i]) {
            next = i * 2 + 2;
        }
        if (next != i) {
            swap(heap, i, next);
            shiftDown(heap, next);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
