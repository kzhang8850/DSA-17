public class MyArrayList {
    private Cow[] elems;
	private int size;

	public MyArrayList() {
		elems = new Cow[10];
		size = 0;
	}

	public MyArrayList(int capacity) {
		elems = new Cow[capacity];
		size = 0;
	}

	public void add(Cow c) {
		if(size == elems.length){
		    resize("increase");

        }
        elems[size] = c;
		size ++;
	}

	public int size() {
		return size;
	}

	public Cow get(int index) {
		if(index < 0 || index >= size) {
		    throw new IndexOutOfBoundsException();
        }
		return elems[index];
	}

	public Cow remove(int index) {
		Cow removed = get(index);

		System.arraycopy(elems, index+1, elems, index, size-index-1);
        size --;
		if(size*4 <= elems.length){
			resize("decrease");
		}
		return removed;
	}

	public void add(int index, Cow c) {
		get(index); //checks for index out of bounds
		if(size == elems.length){
		    resize("increase");
        }

		System.arraycopy(elems, index, elems, index+1, size-index);
        elems[index] = c;
        size ++;

	}

	private void resize(String direction){
		Cow[] temp;

		if(direction == "increase") {
			temp = new Cow[elems.length*2];
			System.arraycopy(elems, 0, temp, 0,  size);
		}
        else{
			temp = new Cow[elems.length/2];
			System.arraycopy(elems, 0, temp, 0,  size);
		}

        elems = temp;
    }
}
