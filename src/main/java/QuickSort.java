public class QuickSort{

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        new QuickSort().sort(arr, 0, 4);
        System.out.println("finish");

        System.out.println(QuickSort.class.getClassLoader());
        System.out.println(QuickSort.class.getClassLoader().getParent());
        System.out.println(QuickSort.class.getClassLoader().getParent().getParent());
    }

    public void sort(int[] arr, int start, int end) {
        if(start >= end) return;
        int target = arr[start];
        int l = start, r = end;
        while (l < r) {
            while (l < r) {
                if (arr[r] < target) {
                    arr[l] = arr[r];
                    break;
                }
                r --;
            }
            while (l < r) {
                if (arr[l] > target) {
                    arr[r] = arr[l];
                    break;
                }
                l ++;
            }
        }
        arr[l] = target;
        sort(arr, start, l - 1);
        sort(arr, l + 1, end);
    }
}
