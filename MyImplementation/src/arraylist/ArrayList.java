package arraylist;

public class ArrayList<E> {

	private Object[] elementData = {};
	
	private int size = 0;
	
	private int minCapacity = 16;
	
	public ArrayList() {
		elementData = new Object[minCapacity];
	}
	
	
	public void add(E item)
	{
		if(size == minCapacity)
		{
			resizeArrayList();
		}
		elementData[size++] = item;
	}
	
	public void add(int index,E element)
	{
		if(index > minCapacity)
		{
			throw new IllegalArgumentException("Index :"+ index +" Size :"+ minCapacity);
		}
		elementData[index] = element;
		
	}
	
	public void resizeArrayList()
	{
		minCapacity = 2 * minCapacity;
		Object[] newElementData = elementData;
		elementData = new Object[minCapacity];
		elementData = newElementData;
	}
}
