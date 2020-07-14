public class LinkedListDeque<T> implements Deque<T> {
    private class ListNode {
        T item;
        ListNode prev;
        ListNode next;
    }

    private int size;
    private ListNode sentFront;
    private ListNode sentBack;

    /* Constructor of linked list deque */
    public LinkedListDeque() {
        size = 0;
        sentFront = new ListNode();
        sentBack = new ListNode();
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
    }

    @Override
    public void addFirst(T it) {
        ListNode p = new ListNode();
        p.item = it;
        p.prev = sentFront;
        p.next = sentFront.next;
        p.next.prev = p;
        sentFront.next = p;
        size++;
    }

    @Override
    public void addLast(T it) {
        ListNode p = new ListNode();
        p.item = it;
        p.prev = sentBack.prev;
        p.next = sentBack;
        sentBack.prev.next = p;
        sentBack.prev = p;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        ListNode curr = sentFront.next;
        while (curr != sentBack) {
            System.out.println(curr.item);
            curr = curr.next;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        ListNode p = sentFront.next;
        sentFront.next = p.next;
        p.next.prev = sentFront;
        p.prev = null;
        p.next = null;
        size--;
        return p.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        ListNode p = sentBack.prev;
        p.prev.next = sentBack;
        sentBack.prev = p.prev;
        p.prev = null;
        p.next = null;
        size--;
        return p.item;
    }

    @Override
    public T get(int index) {
        int i = 0;
        ListNode p = sentFront.next;
        while (i != index) {
            p = p.next;
            i++;
        }
        return p.item;
    }

    /* Support of getRecursive function to work recursively. */
    private T getRecurSup(ListNode p, int i) {
        if (i == 0) {
            return p.item;
        } else {
            return getRecurSup(p.next, i - 1);
        }
    }

    public T getRecursive(int index) {
        return getRecurSup(sentFront.next, index);
    }
}
