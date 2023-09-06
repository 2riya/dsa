public class PartitionLinkedList {
    public static void main(String[] args) {
        ListNode head = LinkedList.createLinkedList(1, 4, 3, 2, 5, 2);
        int x = 3;
        ListNode result = partition(head, x);
        LinkedList.display(result);

        result = partitionWithConstantSpace(head, x);
        LinkedList.display(result);
    }

    private static ListNode partitionWithConstantSpace(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();

        ListNode leftPtr = left;
        ListNode rightPtr = right;

        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                leftPtr.next = p;
                leftPtr = leftPtr.next;
            } else {
                rightPtr.next = p;
                rightPtr = rightPtr.next;
            }
            p = p.next;
        }

        rightPtr.next = null;
        leftPtr.next = right.next;

        return left.next;
    }

    private static ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();

        ListNode leftPtr = left;
        ListNode rightPtr = right;

        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                leftPtr.next = p;
                leftPtr = leftPtr.next;
            } else {
                rightPtr.next = p;
                rightPtr = rightPtr.next;
            }
            p = p.next;
        }

        rightPtr.next = null;
        leftPtr.next = right.next;

        return left.next;
    }
}
