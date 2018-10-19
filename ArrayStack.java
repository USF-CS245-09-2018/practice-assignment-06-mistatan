import java.lang.IllegalStateException;

public class ArrayStack implements Stack{
	private int top = -1;
	private Object[] arr = new Object[10];

	public void push(Object item){
		top = top + 1;
		if(top == arr.length){
			growArr();
		}
		arr[top] = item;

	}
	public Object pop(){
		if(!empty()){
			return arr[top--];
		}throw new IllegalStateException("Nothing in Stack");

	}
	public Object peek(){
		if(!empty()){
			return arr[top];
		}throw new IllegalStateException("Nothing in Stack");

	}
	public boolean empty(){
		return (top == -1);
		
	}
	private void growArr(){
		int longer_arr_len = arr.length * 2;
		Object[] arr_longer = new Object[longer_arr_len];
		
		for(int i = 0; i < arr.length; i++){
			arr_longer[i] = arr[i];
		}
		arr = arr_longer;
	}

}