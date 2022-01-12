package videoeditor;

public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int currentSize = 0;

    private static class Node<E> {

        private Object data;
        private Node<E> next;
        private Node<E> previous;

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public int size() {
        return currentSize;
    }

    @SuppressWarnings("unchecked")
    public void addFirst(Object input) {
        Node<E> newNode = new Node<>((E) input);
        newNode.next = head;
        head = newNode;
        currentSize++;
        if (head.next == null) {
            tail = head;
            return;
        }
        tail = head.next;
    }

    @SuppressWarnings("unchecked")
    public void addLast(Object input) {
        Node<E> newNode = new Node<>((E) input);
        if (size() == 0) {
            addFirst(input);
            return;
        }
        tail.next = newNode;
        tail = newNode;
        currentSize++;
    }

    @SuppressWarnings("unchecked")
    public void add(int index, Object input) {
        if (index == 0) {
            addFirst(input);
            return;
        }
        Node<E> temp1 = head;
        while (--index != 0) {
            temp1 = temp1.next;
        }
        Node<E> temp2 = temp1.next;
        Node<E> newNode = new Node<>((E) input);
        temp1.next = newNode;
        newNode.next = temp2;
        if (newNode.next == null) {
            tail = newNode;
        }
        currentSize++;
    }

    public boolean add(Object input) {
        if (currentSize == 0) {
            addFirst(input);
            return true;
        }
        addLast(input);
        return true;
    }

    public void removeLast() {
        if (tail == null) {
            return;
        }
        Node<E> temp = tail;
        temp.next = null;
        tail = temp;
        currentSize--;
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        currentSize--;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node<E> temp = head;
        while (--index != 0) {
            temp = temp.next;
        }
        Node<E> temp2 = temp.next;
        if (temp2.data == tail) {
            tail = temp;
        }
        temp2.data = null;
        temp.next = temp2.next;

        currentSize--;
    }

    public Node<E> get(int index) {
        Node<E> temp = head;
        if (index == 0) {
            return head;
        } else {
            while (index-- != 0) {
                temp = temp.next;
            }
        }
        if (temp == null) {
            throw new NullPointerException();
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            return "[]";
        }

        Node<E> temp = head;
        while (temp.next != null) {
            sb.append(temp.data);
            temp = temp.next;
        }
        return String.valueOf(sb.append(tail != null ? tail : ""));
    }
}