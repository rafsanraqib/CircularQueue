import java.util.ArrayList;

public class MyCircularQueue {
	
	ArrayList<Integer> queue = new ArrayList<Integer>();
	int size = 0;
    int head = -1;
    int tail = -1;
    
    public MyCircularQueue(int k) {
        
    	queue = new ArrayList<Integer>(k);
        this.size = k;
        
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
    	if (isFull()) {
    		return false;
    	
    	}else if (isEmpty()) {
    		queue.add(value);
    		this.head = 0;
    		this.tail = 0;
    		return true;
    	
    	}else {
	    	this.tail = (tail +=1) % size;
	    	if (this.tail < this.head) {
	    		queue.set(this.tail, value);
	    		return true;
	    	}
	    	queue.add(this.tail,value);
	    	return true;
    	}
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
    	if (isEmpty()) {
    		return false;
    		
    	}else if (queue.get(this.head) == queue.get(this.tail)) {
    		if (this.head == this.tail) {
    		this.head = -1;
    		this.tail = -1;
    		queue.removeAll(queue);
    		return true;
    		
    		}else {
    			this.head = (head +=1) % size;
        		return true;
    		}
    	}
    	else {
    		this.head = (head +=1) % size;
    		return true;
    	}
    }
    
   /** Get the front item from the queue. */
    public int Front() {
        if (this.head == -1) {
        	return -1;
        }
    	return queue.get(this.head);
    }
    
   /** Get the last item from the queue. */
    public int Rear() {
        if (this.tail == -1) {
        	return -1;
        }
    	return queue.get(this.tail);
    }

   /** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		
		if(this.tail == -1 && this.head == -1) {
			return true;
		
		}else {
			return false;
		}
		
	}
	    
	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
	        if (this.head - this.tail == 1) {
	        	return true;
	        
	        }else if (this.head == 0 && this.tail == (size-1)) {
	        	return true;
	        
	        }else {
	        	return false;
	        }
	   }
	    

	public static void main(String[] args) {
     
	}
	
}


