import java.util.*;

public class MyLinkedList<T>  {
    private static class Node<T> {
        T item;
        int data;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T elt, Node<T> next) {
            this.prev = prev;
            this.item = elt;
            this.next = next;
        }
    }

    private final Node<T> first;
    private final Node<T> last;
    private int size = 0;

 
    public MyLinkedList() {
        first = new Node<>(null, null, null);
        last = new Node<>(null, null, null);  
        first.next = last;
        last.prev = first;
    }

    private Node<T> moveUpToPosition(int pos) {
        Node<T> n = first;
        for (int i = 0; i <= pos; ++i) {
            n = n.next;
        }
        return n;
    }

    public void add(int pos, T elt) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException(pos + " is out of bounds");
        }
        Node<T> n = moveUpToPosition(pos-1);
        Node<T> newNode = new Node<>(null, elt, null);
        newNode.prev = n;
        newNode.next = n.next;
        n.next.prev = newNode;
        n.next = newNode;
        size++;
    }

    public void addFirst(T elt) {
        add(0, elt);
    }

    public void addLast(T elt) {
        Node<T> n = last.prev;
        Node<T> newNode = new Node<>(null, elt, null);
        newNode.prev = n;
        newNode.next = n.next;
        n.next.prev = newNode;
        n.next = newNode;
        size++;
    }

    public boolean add(T elt) {
        addLast(elt);
        return true;
    }

    public T removeFirst() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        Node<T> n = first.next;
        T item = n.item;
        n.next.prev = first;
        first.next = n.next;
        --size;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        Node<T> n = last.prev;
        T item = n.item;
        n.prev.next = last;
        last.prev = n.prev;
        --size;
        return item;
    }

    public Object[] toArray() {
        Object data[] = new Object[size];
        Node<T> n = first;
        for (int i = 0; i < size; ++i) {
            n = n.next;
            data[i] = n.item;
        }
        return data;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
    
    public void printAll()
    {
        System.out.println(this.toString());
    }
}