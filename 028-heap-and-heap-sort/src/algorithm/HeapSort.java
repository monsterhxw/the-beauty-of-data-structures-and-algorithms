package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-15
 */
public class HeapSort {

  /** Time Complexity: O(nlogn); Space Complexity: O(1) */
  public void heapSort(int[] nums) {
    // build max heap: Time Complexity: O(n)
    buildMaxHeap(nums);

    // sort :Time Complexity: O(nlogn);
    for (int i = nums.length - 1; i >= 0; i--) {
      swap(nums, 0, i);
      siftDown(nums, i, 0);
    }
  }

  /** Time Complexity: O(n); */
  private void buildMaxHeap(int[] nums) {
    for (int k = (nums.length - 1 - 1) / 2; k >= 0; k--) {
      siftDown(nums, nums.length, k);
    }
  }

  /** Time Complexity: O(logn); */
  private void siftDown(int[] nums, int size, int k) {
    while ((2 * k + 1) < size) {
      int largestPos = 2 * k + 1;
      if (largestPos + 1 < size && nums[largestPos] < nums[largestPos + 1]) {
        largestPos++;
      }
      if (nums[largestPos] <= nums[k]) {
        return;
      } else {
        swap(nums, k, largestPos);
        k = largestPos;
      }
    }
  }

  /** Time Complexity: O(1); */
  private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
