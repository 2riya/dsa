public class LinkedList {

    private LinkedList() {
        throw new IllegalStateException("Utility class, not meant to be instantiated");
    }

    public static <T> ListNode<T> createLinkedList(T... values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode<T> head = new ListNode<>(values[0]);
        ListNode<T> p = head;

        for (int i = 1; i < values.length; i++) {
            p.next = new ListNode<>(values[i]);
            p = p.next;
        }

        return head;
    }

    public static <T> void display(ListNode<T> head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
