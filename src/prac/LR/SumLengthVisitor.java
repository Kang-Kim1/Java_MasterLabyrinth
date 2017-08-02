package prac.LR;

import prac.LR.LRStruct.IAlgo;

public class SumLengthVisitor implements IAlgo<Integer, String, Void> {

	@Override
	public Integer emptyCase(LRStruct<String> host, Void arg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer nonEmptyCase(LRStruct<String> host, Void arg) {
		return host.getDatum().length() + host.getRest().execute(this, null);
	}

	public static void main(String[] args) {

		LRStruct<String> lr = new LRStruct<String>();

		lr.insertFront("333").insertFront("55555").insertFront("7777777")
				.insertFront("1010101010");

		Integer a = lr.execute(new SumLengthVisitor(), null);
		System.out.println(a);
	}

}
