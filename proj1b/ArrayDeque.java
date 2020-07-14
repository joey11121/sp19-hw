public class ArrayDeque<T> implements Deque<T> {
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

    @Override
    public void addFirst(T item) {
        if (size == len) {
            increaseLength();
        }
        deque[nextFirst] = item;
        nextFirst = ((nextFirst - 1) < 0) ? (nextFirst + (len - 1)) % len : (nextFirst - 1) % len;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == len) {
            increaseLength();
        }
        deque[nextLast] = item;
        nextLast = (nextLast + 1) % len;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int i = (nextFirst + 1) % len;
        while (i % len != nextLast) {
            System.out.println(deque[i]);
            i++;
        }
    }

    @Override
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

    @Override
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

    @Override
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
