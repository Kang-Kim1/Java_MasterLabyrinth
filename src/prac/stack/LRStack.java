package prac.stack;

import prac.LR.LRStruct;

public class LRStack<E> {

	private LRStruct<E> _list;

	public LRStack() {
		_list = new LRStruct<E>();
	}

	public void push(E item) {
		_list.insertFront(item);
	}

	public E pop() {

		return _list.removeFront();
	}

	public E peek() {

		return _list.getDatum();
	}

	public String toString() {
		return _list.toString();
	}

	public boolean isEmpty() {
		return _list.execute(new LRStruct.IAlgo<Boolean, E, Void>() {

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

		LRStack<Integer> als = new LRStack<>();

		als.push(2);
		als.push(5);
		als.push(8);
		als.push(10);
		als.push(22);

		als.pop();
		als.pop();
		als.pop();

		System.out.println(als);
		System.out.println(als.isEmpty());
		als.pop();
		als.pop();
		System.out.println(als.isEmpty());

	}

}
