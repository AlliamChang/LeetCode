public class MaxHeap {

    public static void main(String[] args) {
        int[] test = new int[]{5, 3, 1, 6, 4, 2};
        new MaxHeap().sort(test);
        System.out.println(test);
    }

    public void sort(int[] array) {
        buildHeap(array, array.length);
        for (int i = 0; i < array.length; i++) {
            swap(array, 0, array.length - i - 1);
            shiftDown(array, 0, array.length - i - 1);
        }
    }

    public void buildHeap(int[] array, int len) {
        int i = len / 2 - 1;
        for (; i >= 0; i--) {
            shiftDown(array, i, len);
        }
    }

    private void shiftDown(int[] array, int i, int len) {
        int next = i;
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[next]) {
            next = i * 2 + 1;
        }
        if (i * 2 + 2 < len && array[i * 2 + 2] > array[next]) {
            next = i * 2 + 2;
        }
        if (next != i) {
            swap(array, i, next);
            shiftDown(array, next, len);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
