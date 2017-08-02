package prac.LR;

import prac.LR.LRStruct.IAlgo;

public class ProductVisitor implements IAlgo<Integer, Integer, Void> {

	@Override
	public Integer emptyCase(LRStruct<Integer> host, Void arg) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Integer nonEmptyCase(LRStruct<Integer> host, Void arg) {
		return host.getDatum() * host.getRest().execute(this, null);
	}

	public static void main(String[] args) {
		LRStruct<Integer> lr = new LRStruct<Integer>();

		lr.insertFront(1).insertFront(3).insertFront(10);

		Integer a = lr.execute(new ProductVisitor(), null);
		System.out.println(a);
	}

}
