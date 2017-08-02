package prac.queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class ALQueue<E> {

	ArrayList<E> _list;

	public ALQueue() {
		_list = new ArrayList<>();
	}

	public void enqueue(E item) {
		_list.add(item);
	}

	public E dequeue() {
		if (_list.size() == 0) {
			System.out.println("queue is empty");
			return null;
		} else {
			return _list.remove(0);
		}
	}

	public E peek() {
		if (_list.size() == 0) {
			System.out.println("queue is empty");
			return null;
		} else {
			return _list.get(0);
		}
	}
	
	public String toString(){
		return _list.toString();
	}
	
	public static void main(String[] args){
		
		ALQueue<Integer> queue = new ALQueue<>();
		
		queue.enqueue(1);
		queue.enqueue(9);
		queue.enqueue(13);
		queue.enqueue(6);
		queue.enqueue(5);
		queue.enqueue(2);
		
		queue.dequeue();
		queue.dequeue();

		
		System.out.println(queue.toString());
		
		
	}

}