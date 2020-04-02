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
        if (numNodes == 0) {
            head = new Node(element);
            tail = head;
            numNodes++;
        } else {
            Node temp = head;
            head = new Node(element);
            head.next = temp;
            numNodes++;
        }
    }

    public void addLast(E element) {
        if (numNodes == 0) {
            head = new Node(element);
            tail = head;
            numNodes++;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
            numNodes++;
        }
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
            if (head.data.equals(element)) {
                head = head.next;
                numNodes--;
                return true;
            }
            if (step.next.data.equals(element)) {
                step.next = step.next.next;
                numNodes--;
                return true;
            }
            step = step.next;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E element) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E element) {
        Node temp = head;
        int index = 1;
        while (temp.next != null) {
            if (head.data.equals(element)) {
                return 0;
            }
            if (temp.next.data.equals(element)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean add(E element) {
        if (numNodes == 0) {
            head = new Node(element);
            tail = head;
            numNodes++;
            return true;
        } else if (numNodes > 0) {
            tail.next = new Node(element);
            tail = tail.next;
            numNodes++;
            return true;
        } else {
            return false;
        }
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        return (E) head.data;
    }

    public E getLast() {
        return (E) tail.data;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        numNodes = 0;
    }
    public E[] clone(){
        Object[] newList = new Object[numNodes];
        Node temp = head;
       for (int i = 0; i < numNodes; i++){
            newList[i] = (E) temp.data;
            temp = temp.next;
       }
       return (E[]) newList;
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
