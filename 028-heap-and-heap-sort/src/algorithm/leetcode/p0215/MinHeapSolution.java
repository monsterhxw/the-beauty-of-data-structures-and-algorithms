package algorithm.leetcode.p0215;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class MinHeapSolution {
  /** Time Complexity: O((n-k)logk); Space Complexity: O(1); */
  public int findKthLargest(int[] nums, int k) {
    // build k element min heap; O(k);
    buildMinHeap(nums, k);
    // compare other element in order; O((n-k)logk)
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > nums[0]) {
        swap(nums, i, 0);
        siftDown(nums, k, 0);
      }
    }
    return nums[0];
  }

  private void buildMinHeap(int[] nums, int size) {
    for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
      siftDown(nums, size, i);
    }
  }

  private void siftDown(int[] nums, int size, int i) {
    while ((2 * i + 1) < size) {
      int smaller = 2 * i + 1;
      if (smaller + 1 < size && nums[smaller] > nums[smaller + 1]) {
        smaller++;
      }
      if (nums[i] <= nums[smaller]) {
        return;
      } else {
        swap(nums, smaller, i);
        i = smaller;
      }
    }
  }

  private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
