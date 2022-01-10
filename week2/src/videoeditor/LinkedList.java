package videoeditor;


public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int currentSize = 0;

    private class Node<E> {

        private Object data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public int size() {
        return currentSize;
    }

    public void addFirst(Object input) {
        Node<E> newNode = new Node<>((E) input);
        newNode.next = head;
        head = newNode;
        currentSize++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node<E> newNode = new Node<>((E) input);
        if (size() == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            currentSize++;
        }
    }

    public void add(int index, Object input) {
        
    }

    public boolean add(Object input) {
        if (currentSize == 0) {
            addFirst(input);
        } else {
            addLast(input);
        }
        return true;
    }

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

        return String.valueOf(sb.append(temp.data));
    }
}