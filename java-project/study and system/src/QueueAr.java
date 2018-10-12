
public class QueueAr {
    Object[] theArray;
    int currentSize;
    int front;
    int back;
    static final int DEFAULT_CAPACITY = 10;
    public QueueAr() {
    	this(DEFAULT_CAPACITY);
    }
    public QueueAr(int capacity) {
    	theArray = new Object[capacity];
    	makeEmpty();
    }
	private void makeEmpty() {
		// TODO Auto-generated method stub
		currentSize = 0;
		front = 0;
		back = -1;
	}
	public void enqueue(Object x){
		back = increment(back);
		theArray[back] = x;
		currentSize++;
		
	}
	private int increment(int x) {
		// TODO Auto-generated method stub
		if(++x == theArray.length) {
			x=0;
		}
		return x;
	}
	private boolean isFull() {
		// TODO Auto-generated method stub
		return currentSize == theArray.length;
	}
	public boolean isEmpty() {
		return currentSize == 0;
	}
}
