package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-14
 */
public class Test {
  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4, 5, 6};
    System.out.println("nums is: " + Arrays.toString(nums));

    testMaxHeapByHeapifyUp(nums);

    testMaxHeapByHeapifyDown(nums);
  }

  private static void testMaxHeapByHeapifyUp(int[] nums) {
    System.out.println("----------testMaxHeapByHeapifyUp----------");
    System.out.println("call heapifyUp(): ");
    MaxHeap maxHeap = MaxHeap.heapifyUp(nums);
    maxHeap.print();
    System.out.println("call peek(): " + maxHeap.peek());
    System.out.println("call poll(): return is : " + maxHeap.poll());
    System.out.println("call poll(): return is : " + maxHeap.poll());
    System.out.println("call poll(): return is : " + maxHeap.poll());
    maxHeap.print();
    System.out.println("call offer(7)");
    maxHeap.offer(7);
    System.out.println("call offer(8)");
    maxHeap.offer(8);
    System.out.println("call offer(9)");
    maxHeap.offer(9);
    maxHeap.print();
    System.out.println("----------testMaxHeapByHeapifyUp----------");
  }

  private static void testMaxHeapByHeapifyDown(int[] nums) {
    System.out.println("----------testMaxHeapByHeapifyDown----------");
    System.out.println("call heapifyUp(): ");
    MaxHeap maxHeap = MaxHeap.heapifyDown(nums);
    maxHeap.print();
    System.out.println("call peek(): " + maxHeap.peek());
    System.out.println("call poll(): return is : " + maxHeap.poll());
    System.out.println("call poll(): return is : " + maxHeap.poll());
    System.out.println("call poll(): return is : " + maxHeap.poll());
    maxHeap.print();
    System.out.println("call offer(7)");
    maxHeap.offer(7);
    System.out.println("call offer(8)");
    maxHeap.offer(8);
    System.out.println("call offer(9)");
    maxHeap.offer(9);
    maxHeap.print();
    System.out.println("----------testMaxHeapByHeapifyDown----------");
  }
}
