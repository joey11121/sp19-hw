public interface Deque<T> {
    public void addFirst(T it);

    public void addLast(T it);

    public int size();

    default public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public T removeFirst();

    public T removeLast();

    public void printDeque();

    public T get(int i);
}