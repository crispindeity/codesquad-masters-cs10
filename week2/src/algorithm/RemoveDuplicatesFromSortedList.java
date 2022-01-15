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


    @Test
    void removeDuplicatesFromSortedListTest() {
        ListNode listNode5 = new ListNode(3);
        ListNode listNode4 = new ListNode(3, listNode5);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(1, listNode3);
        ListNode listNode = new ListNode(1, listNode2);
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();

        Set<Integer> tmp = new HashSet<>();

        ListNode now = listNode;
        ListNode next = listNode.next;
        while (true) {
            tmp.add(now.val);
            now = next;
            if (now == null) break;
            next = now.next;
        }

        Integer[] value = tmp.toArray(new Integer[0]);
        Integer[] result = new Integer[value.length];

        ListNode testNow = removeDuplicatesFromSortedList.deleteDuplicates(listNode);
        ListNode testNext = testNow.next;

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

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}