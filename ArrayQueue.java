import java.lang.IllegalStateException;

public class ArrayQueue implements Queue{
	private int size = 0;
	private int head = 0;
	private int tail = 0;
	private Object[] arr = new Object[10];

	public Object dequeue(){
		if(empty()){
			throw new IllegalStateException("No Objects in ArrayQueue");
		}
		Object obj = arr[head];
		head++;

		if(head >= arr.length){
			head = 0;
		}
		
		size--;
		return obj;
	}
	public void enqueue(Object item){
		if(size == arr.length){
			growArr();
		}
		arr[tail] = item;
		tail++;

		if(tail >= arr.length){
			tail = 0;
		}
		size++;
	}
	public boolean empty(){
		if(head==tail){
			return true;
		}return false;
	}
	private void growArr(){
		int longer_arr_len = arr.length * 2;
		Object[] arr_longer = new Object[longer_arr_len];
		
		for(int i = 0; i < arr.length; i++){
			arr_longer[i] = arr[i];
		}
		arr = arr_longer;
		head = 0;
		tail = size;
	}
}