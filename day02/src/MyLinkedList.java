public class MyLinkedList<T> {

	private Node head;
	private Node tail;
	private int size;

	private class Node {
		T val;
		Node prev;
		Node next;

		private Node(T d, Node prev, Node next) {
			this.val = d;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(T c) {
		addLast(c);
	}

	public T pop() {
		return removeLast();
	}

	public void addLast(T c) {
		 if(isEmpty()){
		 	head = new Node(c, null, null);
		 	tail = head;
		 }
		 else{
		 	tail.next = new Node(c, tail, null);
		 	tail = tail.next;
		 }
		 size ++;
	}

	public void addFirst(T c) {
		if(isEmpty()){
			head = new Node(c, null, null);
			tail = head;
		}
		else{
			head = new Node(c, null, head);
		}
		size ++;

	}

	public T get(int index) {
		if(index >= 0 && index < size) {
			Node temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp.val;
		}
		throw new IndexOutOfBoundsException();
	}

	public T remove(int index) {
		if(index == 0){
			return removeFirst();
		}
		else if (index == size - 1) {
			return removeLast();
		}
		else{
			T temp = get(index); //checks for a valid index, and gets the said index's value
			Node remover = head;
			for(int i = 0; i < index-1; i++){
				remover = remover.next;
			}
			remover.next = remover.next.next;
			size --;
			return temp;
		}

	}

	public T removeFirst() {
		Node temp = head;

		if(isEmpty()){
			return null;
		}
		else if(size == 1){
			head = null;
			tail = null;
		}
		else{
			head = head.next;
		}
		size --;
		return temp.val;

	}

	public T removeLast() {
		Node temp = tail;

		if(isEmpty()){
			return null;
		}
		else if(size == 1){
			head = null;
			tail = null;
		}
		else{
			tail = tail.prev;
		}
		size --;
		return temp.val;

	}
}