package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-14
 */
public class Test {
  public static void main(String[] args) {
    int[] nums = new int[] {33, 17, 21, 16, 13, 15, 9, 5, 6, 7, 8, 1, 2};
    System.out.println("nums is: " + Arrays.toString(nums));

    testMaxHeap(nums);
  }

  private static void testMaxHeap(int[] nums) {
    System.out.println("----------testMaxHeap----------");
    MaxHeap maxHeap = new MaxHeap();
    maxHeap.print();

    System.out.println("call heapifyUp");
    maxHeap.heapifyUp(nums);
    maxHeap.print();

    System.out.println("call offer(22)");
    maxHeap.offer(22);
    maxHeap.print();

    System.out.println("call offer(23)");
    maxHeap.offer(23);
    maxHeap.print();

    System.out.println("call offer(24)");
    maxHeap.offer(24);
    maxHeap.print();
  }
}
