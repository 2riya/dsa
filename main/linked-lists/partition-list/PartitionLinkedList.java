public class PartitionLinkedList {
    public static void main(String[] args) {
        ListNode<Integer> head = LinkedList.createLinkedList(1, 4, 3, 2, 5, 2);
        int x = 3;
        ListNode<Integer> result = partition(head, x);
        LinkedList.display(result);

        result = partitionWithConstantSpace(head, x);
        LinkedList.display(result);
    }

    private static ListNode<Integer> partitionWithConstantSpace(ListNode<Integer> head, int x) {
        ListNode<Integer> left = new ListNode<>();
        ListNode<Integer> right = new ListNode<>();

        ListNode<Integer> leftPtr = left;
        ListNode<Integer> rightPtr = right;

        ListNode<Integer> p = head;

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

    private static ListNode<Integer> partition(ListNode<Integer> head, int x) {
        ListNode<Integer> left = new ListNode<>();
        ListNode<Integer> right = new ListNode<>();

        ListNode<Integer> leftPtr = left;
        ListNode<Integer> rightPtr = right;

        ListNode<Integer> p = head;

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
