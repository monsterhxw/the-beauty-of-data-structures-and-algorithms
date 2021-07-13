package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-14
 */
public class MaxHeap {
  private int[] heap;
  private int capacity;
  private int size;

  public MaxHeap() {
    this(16);
  }

  public MaxHeap(int capacity) {
    this.capacity = capacity;
    this.heap = new int[this.capacity];
    this.size = 0;
  }

  public void offer(int element) {
    if (size >= capacity) {
      throw new ArrayIndexOutOfBoundsException();
    }
    heap[size] = element;
    siftUp(size);
    size++;
  }

  public void heapifyUp(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      offer(nums[i]);
    }
  }

  /** Time Complexity: O(logn); */
  private void siftUp(int k) {
    while (k != 0 && heap[k] > heap[(k - 1) / 2]) {
      swap(heap, k, (k - 1) / 2);
      k = (k - 1) / 2;
    }
  }

  private void swap(int[] heap, int index1, int index2) {
    int temp = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = temp;
  }

  public void print() {
    System.out.println(
        "head is: "
            + Arrays.toString(heap)
            + "; size is: "
            + size
            + "; capacity is:"
            + capacity
            + ";");
  }
}
