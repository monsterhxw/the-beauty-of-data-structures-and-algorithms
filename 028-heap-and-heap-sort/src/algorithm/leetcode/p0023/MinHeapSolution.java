package algorithm.leetcode.p0023;

/**
 * @author XueweiHuang
 * @created 2021-07-18
 */
public class MinHeapSolution {

  static class MinListNodeHeap {
    private ListNode[] heap;
    private int size;
    private int capacity;

    MinListNodeHeap() {
      this(16);
    }

    MinListNodeHeap(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      this.heap = new ListNode[capacity];
    }

    public boolean isEmpty() {
      return size == 0;
    }

    /** Time Complexity: O(logk); */
    public void offer(ListNode e) {
      if (size >= capacity) {
        throw new ArrayIndexOutOfBoundsException();
      } else {
        heap[size] = e;
        siftUp(heap, size);
        size++;
      }
    }

    /** Time Complexity: O(logk); */
    private void siftUp(ListNode[] heap, int k) {
      while (k != 0 && heap[k].val < heap[(k - 1) / 2].val) {
        swap(heap, k, (k - 1) / 2);
        k = (k - 1) / 2;
      }
    }

    /** Time Complexity: O(logk); */
    public ListNode poll() {
      if (isEmpty()) {
        return null;
      } else {
        ListNode poll = heap[0];
        size--;
        heap[0] = heap[size];
        heap[size] = null;
        siftDown(heap, size, 0);
        return poll;
      }
    }

    /** Time Complexity: O(logk); */
    private void siftDown(ListNode[] heap, int size, int k) {
      while ((2 * k + 1) < size) {
        int smaller = 2 * k + 1;
        if (smaller + 1 < size && heap[smaller].val > heap[smaller + 1].val) {
          smaller++;
        }
        if (heap[k].val <= heap[smaller].val) {
          return;
        } else {
          swap(heap, k, smaller);
          k = smaller;
        }
      }
    }

    private void swap(ListNode[] heap, int index1, int index2) {
      ListNode temp = heap[index1];
      heap[index1] = heap[index2];
      heap[index2] = temp;
    }
  }

  /** Time Complexity: O(knlogk); Space Complexity: O(k); */
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    } else {
      MinListNodeHeap minHeap = new MinListNodeHeap(lists.length);
      for (int k = 0; k < lists.length; k++) {
        if (lists[k] != null) {
          minHeap.offer(lists[k]);
        }
      }
      ListNode dummy = new ListNode(-1);
      ListNode tail = dummy;
      while (!minHeap.isEmpty()) {
        ListNode min = minHeap.poll();
        tail.next = min;
        if (min.next != null) {
          minHeap.offer(min.next);
        }
        tail = tail.next;
      }
      return dummy.next;
    }
  }
}
