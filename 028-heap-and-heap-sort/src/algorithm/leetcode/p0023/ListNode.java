package algorithm.leetcode.p0023;

/** Definition for singly-linked list. */
public class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode createSinglyLinkedList(int[] nums) {
    if (null == nums || 0 == nums.length) {
      return new ListNode();
    } else {
      ListNode head = new ListNode(nums[0]);
      for (int i = 1; i < nums.length; i++) {
        createNodeAtTail(head, nums[i]);
      }
      return head;
    }
  }

  private static void createNodeAtTail(ListNode head, int val) {
    ListNode newNode = new ListNode(val);
    ListNode tail = head;
    while (null != tail.next) {
      tail = tail.next;
    }
    tail.next = newNode;
  }

  public static void printLinkedList(ListNode head) {
    ListNode cur = head;
    while (null != cur) {
      System.out.print(String.format("%d%s", cur.val, cur.next != null ? "->" : "->null"));
      cur = cur.next;
    }
    System.out.println();
  }
}
