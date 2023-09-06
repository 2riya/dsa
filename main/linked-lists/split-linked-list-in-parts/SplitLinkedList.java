public class SplitLinkedList {
    public static void main(String[] args) {
        ListNode head = LinkedList.createLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int k = 3;

        System.out.print("Input: ");
        LinkedList.display(head);

        ListNode[] result = splitListToParts(head, k);

        System.out.println("Output: ");
        for (ListNode node : result) {
            LinkedList.display(node);
        }
    }

    private static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];

        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }

        int i = 0;
        p = head;
        while (len > 0) { // this loop will run 'k' times
            if (len % k == 0) {
                res[i] = p;
                p = splitAfterNNodes(p, len / k);
                len -= len / k;
            } else {
                res[i] = p;
                p = splitAfterNNodes(p, len / k + 1); // if len is not fully divisible by k, then 1 extra node will be added to current partition
                len -= len / k + 1;
            }
            i++;
            k--; // k is no. of partitions to be made, after each partition is done, remaining partitions to be made gets decremented by 1
        }

        return res;
    }

    private static ListNode splitAfterNNodes(ListNode head, int n) {
        ListNode p = head;
        ListNode prev = null;
        for (int i = 0; i < n; i++) {
            prev = p;
            p = p.next;
        }

        prev.next = null;

        return p;
    }
}

