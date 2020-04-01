package linkedlist;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes;

    public MyLinkedList() {

    }

    public MyLinkedList(Object data) {
        head = new Node(data);
        tail = head;
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        tail = head;
        numNodes++;
    }

    public void addLast(E element) {
        tail.next = new Node(element);
        tail = tail.next;
        numNodes++;
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }

    public E remove(int index) {
        Node beforeElement = head;
        Node holder;

        for (int i = 0; i < index - 1 && beforeElement.next != null; i++) {
            beforeElement = beforeElement.next;
        }
        holder = beforeElement.next;

        beforeElement.next = holder.next;
        numNodes--;
        return (E) holder;
    }

    public boolean remove(E element) {
        Node step = head;
        while (step.next != null) {
            if (step.getData().equals(element)) {
                Node deleteElement = step.next.next;
                step.next = deleteElement;
                numNodes--;
                return true;
            }
            step = step.next;
        }
        return false;
    }
    public int size(){
        return numNodes;
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
}
