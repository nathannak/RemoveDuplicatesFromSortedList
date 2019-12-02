
public class Main {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
       }

    public static void main(String[] args) {

        //1->1->2->3->3->4->4->5
        ListNode ln                             = new ListNode(1);
        ln.next                                 = new ListNode(1);
        ln.next.next                            = new ListNode(2);
        ln.next.next.next                       = new ListNode(3);
        ln.next.next.next.next                  = new ListNode(3);
        ln.next.next.next.next.next             = new ListNode(4);
        ln.next.next.next.next.next.next        = new ListNode(4);
        ln.next.next.next.next.next.next.next   = new ListNode(5);

        System.out.println( deleteDuplicates(ln) );
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0 == head.val ? 1 : 0); // to guarantee the dummy node is not same as the original head.

        ListNode cur = head;
        dummy.next = head;
        ListNode pre = dummy;
        ListNode first = dummy;  // the first node in the new unduplicated(result) list.

        while (cur != null && cur.next != null) {
            if (cur.val != pre.val && cur.val != cur.next.val) { // we found a unique node, we connect it at the tail of the unduplicated list, and update the first node.
                first.next = cur;
                first = first.next;
            }
            pre = cur;
            cur = cur.next;
        }

        if (pre.val != cur.val) { // the last node needs to be dealt with independently
            first.next = cur;
            first = first.next;
        }

        first.next = null; // the subsequent list is duplicate.

        return dummy.next;
    }

}
