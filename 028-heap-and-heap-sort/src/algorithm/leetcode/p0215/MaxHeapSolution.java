package algorithm.leetcode.p0215;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class MaxHeapSolution {
  /** Time Complexity: O(nlogn); Space Complexity: O(1) */
  public int findKthLargest(int[] nums, int k) {
    // build max heap; Time Complexity: O(n);
    buildMaxHeap(nums, nums.length);
    // delete heap root node; Time Complexity: O(klogn);
    for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
      swap(nums, 0, i);
      siftDown(nums, i, 0);
    }
    return nums[0];
  }

  /** Time Complexity: O(n); */
  private void buildMaxHeap(int[] nums, int size) {
    // i = size - 1;
    // (i - 1) / 2
    for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
      siftDown(nums, nums.length, i);
    }
  }

  private void siftDown(int[] nums, int size, int i) {
    while ((2 * i + 1) < size) {
      int largestPos = 2 * i + 1;
      if (largestPos + 1 < size && nums[largestPos] < nums[largestPos + 1]) {
        largestPos++;
      }
      if (nums[i] >= nums[largestPos]) {
        return;
      } else {
        swap(nums, largestPos, i);
        i = largestPos;
      }
    }
  }

  private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
