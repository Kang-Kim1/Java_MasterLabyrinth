package prac.queue;

import prac.LR.LRStruct;

public class LRQueue<E> {

	private LRStruct<E> _front;
	private LRStruct<E> _back;

	public LRQueue() {
		_front = new LRStruct<E>();
		_back = _front;
	}

	public void enqueue(E item) {
		System.out.println("enqueue item : " + item);
		_back.insertFront(item);
		System.out.println("***1.front_datum after enqueue : " + _front);
		_back = _back.getRest();
		System.out.println("***2.front_datum after enqueue : " + _front);
		System.out.println("back after enqueue : " + _back);
	}

	public E dequeue() {
		System.out.println("-----------------dequeue-------------");

		E item = _front.removeFront();

		return item;

	}

	public E peek() {
		return _front.getDatum();
	}

	public String toString() {
		return _front.getDatum() + " " + _front.getRest();
	}

	public boolean isEmpty() {
		return _front.execute(new LRStruct.IAlgo<Boolean, E, Void>() {

			@Override
			public Boolean emptyCase(LRStruct<E> host, Void arg) {
				return true;
			}

			@Override
			public Boolean nonEmptyCase(LRStruct<E> host, Void arg) {
				return false;
			}
		}, null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LRQueue<Integer> lrq = new LRQueue<Integer>();
		lrq.enqueue(2);
		lrq.enqueue(4);
		lrq.enqueue(7);
		lrq.enqueue(5);

		lrq.dequeue();

		System.out.println(lrq);

		System.out.println(lrq.isEmpty());

		lrq.dequeue();
		lrq.dequeue();
		lrq.dequeue();
		System.out.println(lrq.isEmpty());
	}

}
