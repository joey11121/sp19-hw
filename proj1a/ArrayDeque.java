public class ArrayDeque<T>{
	T[] deque;
	int size; // The size of the deque.
	int len; // The length of array.
	int front, rear;	//front == rear, then the list must be empty, front

	public ArrayDeque(){
		deque = (T[]) new Object[8];	//Object should be in capital.
		len = 8;
		size = 0;
		front = 0;
		rear = 0;
	}
	public void addFirst(T item){
		if((rear - front) % len == 1 || (rear - front) % len == 7) {
			resize();
		}
		front = (front - 1) % len;
		deque[front] = item;
		size++;
	}
	public void addLast(T item){
		if((rear - front) % len == 1 || (rear - front) % len == 7) {
			resize();
		}
		rear = (rear + 1) % len;
		deque[rear] = item;
		size++;
 	}
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}		
		return false;
	}
	public int size(){
		return size;
	}
	public void printDeque(){
		for(T it : deque){
			System.out.println(it);
		}
	}

	public T removeFirst(){
		T res = deque[front];
		front = (front + 1) % len;
		size--;
		return res;
	}
	public T removeLast(){
		T res = deque[rear];
		rear = (rear - 1) % len;
		size--;
		return res;
	}
	public T get(int index){
		return deque[index];
	}
	private void resize(){
		T[] newDeque = (T[]) new Object[len * 2];
		System.arraycopy(deque, 0, newDeque, 0, rear + 1);
		System.arraycopy(deque, front, newDeque, front, len - front);
		int diff = len - front;
		len = len * 2;
		front = len - diff;
		deque = newDeque;
		newDeque = null;
	}


}
