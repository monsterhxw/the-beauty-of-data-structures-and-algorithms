package algorithm.leetcode.p0215;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class Test {
  public static void main(String[] args) {
    int[] nums = new int[] {3, 2, 1, 5, 6, 4};
    int k = 3;
    testMaxHeapSolution(nums, k);
    testMinHeapSolution(nums, k);
  }

  private static void testMaxHeapSolution(int[] nums, int k) {
    System.out.println("----------testMaxHeapSolution----------");
    print(nums, k);
    MaxHeapSolution solution = new MaxHeapSolution();
    int[] copyOf = Arrays.copyOf(nums, nums.length);
    System.out.println(
        "the k(" + k + ") th largest element is: " + solution.findKthLargest(copyOf, k));
    System.out.println(Arrays.toString(copyOf));
  }

  private static void testMinHeapSolution(int[] nums, int k) {
    System.out.println("-----------testMinHeapSolution---------");
    print(nums, k);
    MinHeapSolution solution = new MinHeapSolution();
    int[] copyOf = Arrays.copyOf(nums, nums.length);
    System.out.println(
        "the k(" + k + ") th largest element is: " + solution.findKthLargest(copyOf, k));
    System.out.println(Arrays.toString(copyOf));
  }

  private static void print(int[] nums, int k) {
    System.out.println("nums is: " + Arrays.toString(nums));
    System.out.println("k is: " + k);
  }
}
