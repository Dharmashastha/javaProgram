package stack;

public class Entry<E> {

	private E value;

	public Entry(E value) {
		this.value = value;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

}