package az.edu.turing.module3.lesson04;


import az.edu.turing.module3.lesson04.exceptions.OutOfBoundCheckException;

public class MyLinkedList<E> {
    private int size = 0;
    private Node<E> head;

    private static class Node<E> {
        Node prev;
        Node<E> next;
        public E element;

        public Node(E element) {
            this.element = element;
        }
    }

    public void add(E e) {
        Node<E> node = new Node<>(e);

        if (head == null) {
            head = node;
            size++;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = node;
            node.prev = last;

            size++;
        }

    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new OutOfBoundCheckException("size: " + size + " index: " + index);
        }
        Node<E> first = head;
        int count = 0;
        while (count != index) {
            count++;
            first = first.next;
        }

        return first.element;
    }

    public void remove(int index) {
        Node<E> last = head;
        int count = 0;

        if (index == 0) {
            head = head.next;
        } else {
            while (count != index) {
                last = last.next;
                count++;
            }
            if (index == size - 1) {
                last.prev.next = null;
            } else {
                last.prev.next = last.next;
                last.next.prev = last.prev;
            }
        }

    }

    public void print() {
        if (head != null) {
            Node<E> last = head;
            System.out.println(head.element);
            while (last.next != null) {
                last = last.next;
                System.out.println(last.element);
            }
        } else {
            System.out.println("null");
        }

    }

    public int size() {
        return size;
    }

}
