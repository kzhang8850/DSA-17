public class MyArrayList<T> {
    private T[] elems;
	private int size;

	public MyArrayList() {
		elems = (T[]) new Object[10];
		size = 0;
	}

	public MyArrayList(int capacity) {
		elems = (T[]) new Object[capacity];
		size = 0;
	}

	public void add(T c) {
		if(size == elems.length){
		    resize("increase");

        }
        elems[size] = c;
		size ++;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		if(index < 0 || index >= size) {
		    throw new IndexOutOfBoundsException();
        }
		return elems[index];
	}

	public T remove(int index) {
		T removed = get(index);

		System.arraycopy(elems, index+1, elems, index, size-index-1);
        size --;
		if(size*4 <= elems.length){
			resize("decrease");
		}
		return removed;
	}

	public void add(int index, T c) {
		get(index); //checks for index out of bounds
		if(size == elems.length){
		    resize("increase");
        }

		System.arraycopy(elems, index, elems, index+1, size-index);
        elems[index] = c;
        size ++;

	}

	private void resize(String direction){
		T[] temp;

		if(direction == "increase") {
			temp = (T[]) new Object[elems.length*2];
			System.arraycopy(elems, 0, temp, 0,  size);
		}
        else{
			temp = (T[]) new Object[elems.length/2];
			System.arraycopy(elems, 0, temp, 0,  size);
		}

        elems = temp;
    }
}
