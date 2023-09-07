public class RevListTwo {
    public static void main(String[] args) {
        ListNode head = LinkedList.createLinkedList(1,2,3,4,5);
        int left = 2;
        int right = 4;

        ListNode output = reverseBetween(head, left, right);
        LinkedList.display(output);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinelNode = new ListNode(-1, head);
        ListNode ptr = head;

        ListNode nodeBeforeLeft = sentinelNode;

        // let ptr reach left
        for (int i = 1; i < left; i++) {
            nodeBeforeLeft = ptr;
            ptr = ptr.next;
        }

        // reverse nodes from left to right, i.e., (reverse right - left + 1) nodes, starting from left
        ListNode prev = nodeBeforeLeft;
        ListNode curr = ptr;
        ListNode next = null;
        for (int i = 1; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        // left node should be pointing to node after right
        nodeBeforeLeft.next.next = curr;

        // node before left node should be pointing to node at right
        nodeBeforeLeft.next = prev;

        return sentinelNode.next;
    }
}
