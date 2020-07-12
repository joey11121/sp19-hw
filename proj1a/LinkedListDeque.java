public class LinkedListDeque<T> { //For convention java style, <> is followed by a spece.
    //Instant variables for LinkedListDeque class. 
    private class ListNode {
        T item;
        ListNode prev;
	    ListNode next;
	}
	private int size;
	private ListNode sentFront;
	private ListNode sentBack;
	public LinkedListDeque() {
		size = 0;
		sentFront = new ListNode();
		sentBack = new ListNode();
		sentFront.next = sentBack;
		sentBack.prev = sentFront;
	}
	public void addFirst(T it) {
		ListNode p = new ListNode();
		p.item = it;
		p.prev = sentFront;
		p.next = sentFront.next;
		p.next.prev = p;
		sentFront.next = p;
		size++;
	}
	public void addLast(T it) {
		ListNode p = new ListNode();
		p.item = it;
		p.prev = sentBack.prev;
		p.next = sentBack;
	  	sentBack.prev.next = p;
		sentBack.prev = p;
		size++;
 	}
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}		
		return false;
	}
	public int size() {
		return size;
	}
	public void printDeque() {
		ListNode curr = sentFront.next;
		while (curr != sentBack) {
			System.out.println(curr.item);
			curr = curr.next;
		}		
	}

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
