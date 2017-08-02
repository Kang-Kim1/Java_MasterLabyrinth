package prac.BR;

import prac.BR.BRStruct.IAlgo;

public class InOrderVisitor implements IAlgo<Void, Integer, Void> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BRStruct<Integer> main = new BRStruct<>();
		main.insertRoot(40);
		BRStruct<Integer> left1 = new BRStruct<>();
		left1.insertRoot(20);
		BRStruct<Integer> left2 = new BRStruct<>();
		left2.insertRoot(10);
		BRStruct<Integer> left1right = new BRStruct<>();
		left1right.insertRoot(25);

		BRStruct<Integer> right1 = new BRStruct<>();
		right1.insertRoot(55);
		BRStruct<Integer> right2 = new BRStruct<>();
		right2.insertRoot(60);
		BRStruct<Integer> right1left = new BRStruct<>();
		right1left.insertRoot(50);

		main.setLeft(left1);
		main.setRight(right1);
		left1.setLeft(left2);
		left1.setRight(left1right);
		right1.setRight(right2);
		right1.setLeft(right1left);

		System.out.println(main);
		// br.setLeft(rest)
		main.execute(new InOrderVisitor(), null);
	}

	@Override
	public Void emptyCase(BRStruct<Integer> host, Void arg) {
		return null;
	}

	@Override
	public Void nonEmptyCase(BRStruct<Integer> host, Void arg) {
		host.getLeft().execute(this, null);
		System.out.println(host.getDatum());
		host.getRight().execute(this, null);

		return null;
	}

}
