package algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode now = head;
        ListNode next = head.next;
        while (next != null) {
            if (now.val == next.val) {
                if (next.next == null) {
                    now.next = null;
                    return head;
                }
                now.next = next.next;
                next = now;
            }
            now = next;
            next = now.next;
        }
        return head;
    }
}

class RemoveDuplicatesFromSortedListTest {

    private final Set<Integer> tmp = new HashSet<>();
    private final ListNode listNode5 = new ListNode(3);
    private final ListNode listNode4 = new ListNode(3, listNode5);
    private final ListNode listNode3 = new ListNode(2, listNode4);
    private final ListNode listNode2 = new ListNode(1, listNode3);
    private final ListNode listNode = new ListNode(1, listNode2);
    private final RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();

    @Test
    void removeDuplicatesFromSortedListTest() {
        ListNode now = listNode;
        ListNode next = listNode.next;
        Integer[] value = tmp.toArray(new Integer[0]);
        ListNode testNow = removeDuplicatesFromSortedList.deleteDuplicates(listNode);
        ListNode testNext = testNow.next;
        Integer[] result = new Integer[value.length];

        while (true) {
            tmp.add(now.val);
            now = next;
            if (now == null) break;
            next = now.next;
        }

        for (int i = 0; ; i++) {
            result[i] = testNow.val;
            testNow = testNext;
            if (testNow == null) break;
            testNext = testNow.next;
        }
        assertArrayEquals(result, value);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}