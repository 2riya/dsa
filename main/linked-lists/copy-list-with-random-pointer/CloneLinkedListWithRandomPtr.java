import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandomPtr {
    public RandomNode copyRandomListUsingHashMap(RandomNode head) {
        Map<RandomNode, RandomNode> oldVsNewNodeMap = new HashMap<>();

        RandomNode ptr = head;
        while (ptr != null) {
            RandomNode clonedListNode = new RandomNode(ptr.val);
            oldVsNewNodeMap.put(ptr, clonedListNode);
            ptr = ptr.next;
        }

        // replicate pointers of given linked list
        ptr = head;
        while (ptr != null) {
            oldVsNewNodeMap.get(ptr).next = oldVsNewNodeMap.get(ptr.next);
            oldVsNewNodeMap.get(ptr).random = oldVsNewNodeMap.get(ptr.random);
            ptr = ptr.next;
        }

        return oldVsNewNodeMap.get(head);
    }

    public RandomNode copyRandomListWithConstantSpace(RandomNode head) {
        if (head == null) {
            return head;
        }

        RandomNode ptr = head;
        while (ptr != null) {
            RandomNode clonedListNode = new RandomNode(ptr.val); // node of cloned list

            /* insert new node between old and old.next */
            clonedListNode.next = ptr.next;
            ptr.next = clonedListNode;

            // move forward current pointer
            ptr = clonedListNode.next;
        }

        // replicate random pointers
        ptr = head;
        while (ptr != null) {
            if (ptr.random != null) {
                ptr.next.random = // next <- corresponding new node, next.random <- new node's random
                    ptr.random.next; // random <- old node's random pointer, random.next <- corresponding new node of random

            }

            ptr = ptr.next.next;
        }

        // detach linked lists
        ptr = head;
        RandomNode clonedListHead = ptr.next;
        while (ptr != null) {
            RandomNode clonedListNode = ptr.next;

            ptr.next = ptr.next.next;

            /* this check is for detaching last node of given linked list,
                in which case cloned list's next will already be null */
            if (clonedListNode.next != null) {
                clonedListNode.next = clonedListNode.next.next;
            }

            ptr = ptr.next;
        }

        return clonedListHead;
    }

    private class RandomNode {
        private int val;
        private RandomNode next;
        private RandomNode random;

        RandomNode(int val) {
            this.val = val;
        }

        RandomNode(int val, RandomNode next) {
            this.val = val;
            this.next = next;
        }

        RandomNode(int val, RandomNode next, RandomNode random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
}
