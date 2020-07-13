public class ArrayDeque<T> {
    private T[] deque;
    private int size;
    private int len;
    private int nextFirst, nextLast;

    public ArrayDeque() {
        deque = (T[]) new Object[8];
        len = deque.length;
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public void addFirst(T item) {
        if (size == len) {
            increaseLength();
        }
        deque[nextFirst] = item;
        nextFirst = ((nextFirst - 1) < 0) ? (nextFirst + (len - 1)) % len : (nextFirst - 1) % len;
        size++;
    }

    public void addLast(T item) {
        if (size == len) {
            increaseLength();
        }
        deque[nextLast] = item;
        nextLast = (nextLast + 1) % len;
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
        int i = (nextFirst + 1) % len;
        while (i % len != nextLast) {
            System.out.println(deque[i]);
            i++;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = (nextFirst + 1) % len;
        T res = deque[nextFirst];
        deque[nextFirst] = null;
        size--;
        if (size < len / 2 && len > 4) {
            decreaseLength();
        }
        return res;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = (nextLast - 1) < 0 ? (nextLast + (len - 1)) % len : (nextLast - 1) % len;
        T res = deque[nextLast];
        deque[nextLast] = null;
        size--;
        if (size < len / 2 && len > 4) {
            decreaseLength();
        }
        return res;
    }

    public T get(int index) {
        int start = (nextFirst + 1) % len;
        index = (index + start) % len;
        if (size == 0 && deque[index] == null) {
            return null;
        }
        return deque[index];
    }

    private void increaseLength() {
        T[] newDeque = (T[]) new Object[len * 2];
        int start = (nextFirst + 1) % len;
        int i = 0;
        int time = 0;
        while (time < size) {
            newDeque[i] = deque[start];
            i++;
            start = (start + 1) % len;
            time++;
        }
        len = len * 2;
        nextFirst = len - 1;
        nextLast = size;
        deque = newDeque;
    }

    private void decreaseLength() {
        T[] newDeque = (T[]) new Object[len / 2];
        int start = (nextFirst + 1) % len;
        int i = 0, time = 0;
        while (time < size) {
            newDeque[i] = deque[start];
            i++;
            start = (start + 1) % len;
            time++;
        }
        len = len / 2;
        nextFirst = len - 1;
        nextLast = size;
        deque = newDeque;
    }
}
