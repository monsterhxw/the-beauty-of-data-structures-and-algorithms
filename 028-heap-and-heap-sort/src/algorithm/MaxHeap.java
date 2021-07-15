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

  /** Time Complexity: O(logn); */
  public void offer(int element) {
    if (size >= capacity) {
      throw new ArrayIndexOutOfBoundsException();
    } else {
      // insert at the end
      heap[size] = element;
      // heapify (uses sift up) the array
      siftUp(size);
      size++;
    }
  }

  /** Time Complexity: O(logn); */
  public int poll() {
    int rootVal = peek();
    heap[0] = heap[size - 1];
    heap[size - 1] = 0;
    size--;
    siftDown(0);
    return rootVal;
  }

  /** Time Complexity: O(1); */
  public int peek() {
    return heap[0];
  }

  /** Time Complexity: O(logn); */
  private void siftUp(int k) {
    while (k != 0 && heap[k] > heap[(k - 1) / 2]) {
      swap(heap, k, (k - 1) / 2);
      k = (k - 1) / 2;
    }
  }

  /** Time Complexity: O(logn); */
  private void siftDown(int k) {
    while ((2 * k + 1) < heap.length) {
      int largestPos = 2 * k + 1;
      if (largestPos + 1 < heap.length && heap[largestPos] < heap[largestPos + 1]) {
        largestPos++;
      }
      if (heap[largestPos] <= heap[k]) {
        return;
      } else {
        swap(heap, k, largestPos);
        k = largestPos;
      }
    }
  }

  private static void swap(int[] heap, int index1, int index2) {
    int temp = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = temp;
  }

  /** Time Complexity: O(nlogn); */
  public static MaxHeap heapifyUp(int[] nums) {
    MaxHeap heap = new MaxHeap(nums.length);
    heap.heap = Arrays.copyOf(nums, nums.length);
    heap.size = nums.length;
    // parent of last node index is: (lastIndex - 1) / 2; lastIndex = size - 1;
    int lastIndex = nums.length - 1;
    for (int i = (lastIndex - 1) / 2; i < nums.length; i++) {
      siftUp(heap.heap, i);
    }
    return heap;
  }

  private static void siftUp(int[] array, int k) {
    while (k != 0 && array[k] > array[(k - 1) / 2]) {
      swap(array, k, (k - 1) / 2);
      k = (k - 1) / 2;
    }
  }

  /** Time Complexity: O(n); */
  public static MaxHeap heapifyDown(int[] nums) {
    MaxHeap heap = new MaxHeap(nums.length);
    heap.heap = Arrays.copyOf(nums, nums.length);
    heap.size = nums.length;
    for (int i = nums.length - 1; i >= 0; i--) {
      siftDown(heap.heap, i);
    }
    return heap;
  }

  private static void siftDown(int[] array, int k) {
    while ((2 * k + 1) < array.length) {
      int largestPos = 2 * k + 1;
      if (largestPos + 1 < array.length && array[largestPos] < array[largestPos + 1]) {
        largestPos++;
      }
      if (array[largestPos] <= array[k]) {
        return;
      } else {
        swap(array, largestPos, k);
        k = largestPos;
      }
    }
  }

  public void print() {
    print(false);
  }

  public void print(boolean hasDetails) {
    System.out.println(
        "head array is: "
            + Arrays.toString(heap)
            + "; size is: "
            + size
            + "; capacity is:"
            + capacity
            + ";");
    if (hasDetails) {
      System.out.println("Details: ");
      for (int i = 0; i <= ((size - 1) - 1) / 2; i++) {
        int p = i;
        int lc = i * 2 + 1;
        int rc = i * 2 + 2;
        System.out.printf(
            "Parent: %s, Left child: %s, Right child: %s %s",
            heap[i],
            lc < size ? heap[i * 2 + 1] : "nil",
            rc < size ? heap[i * 2 + 2] : "nil",
            "\n");
      }
    }
  }
}
