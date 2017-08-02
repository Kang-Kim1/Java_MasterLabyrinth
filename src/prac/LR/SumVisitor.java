package prac.LR;
public class SumVisitor implements LRStruct.IAlgo<Integer, Integer, Void> {

	@Override
	public Integer emptyCase(LRStruct<Integer> host, Void arg) {
		return 0;
	}

	@Override
	public Integer nonEmptyCase(LRStruct<Integer> host, Void arg) {
		return host.getDatum() + host.getRest().execute(this, null);
	}

	public static void main(String[] args) {

		LRStruct<Integer> lr = new LRStruct<Integer>();
		lr.insertFront(30).insertFront(-10).insertFront(-5);
		Integer a = lr.execute(new SumVisitor(), null);
		System.out.println(a);
	}
}
