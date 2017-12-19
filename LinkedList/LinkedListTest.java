
public class LinkedListTest {
    public static void main(String args[]) {
        MyLinkedList<String> mylist = new MyLinkedList<String>();

        mylist.addFirst("Abby");
        mylist.addFirst("Adam");
        mylist.addLast("Betty");
        mylist.addLast("Cathy");
        mylist.addLast("Daisy");
        mylist.printAll();
        mylist.removeFirst();
        mylist.printAll();
        mylist.removeLast();
        mylist.printAll();
        System.out.println("===== Well Done ====");

    }
}