public class RevList {
    public static void main(String[] args) {
        ListNode head = LinkedList.createLinkedList(1,2,3,4,5);

        ListNode output = reverseList(head);
        LinkedList.display(output);
    }
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
