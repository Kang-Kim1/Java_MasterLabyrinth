package prac.BR;

public class BinarySearchTree {

	private BRStruct<Integer> _tree;

	public BinarySearchTree() {
		_tree = new BRStruct<Integer>();
	}

	public void insertRoot(Integer item) {
		_tree.execute(new Visitor(), item);
	}

	private class Visitor implements
			prac.BR.BRStruct.IAlgo<Void, Integer, Integer> {

		@Override
		public Void emptyCase(BRStruct<Integer> host, Integer arg) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Void nonEmptyCase(BRStruct<Integer> host, Integer arg) {
			if (_tree.getDatum() > arg) {
				BRStruct<Integer> right = new BRStruct<Integer>();
				right = _tree.getRight();
				_tree.insertRoot(arg);
				_tree.setRight(right);

			} else if (host.getDatum() <= arg) {
				BRStruct<Integer> left = new BRStruct<Integer>();
				left = _tree.getRight();
				_tree.insertRoot(arg);
				_tree.setRight(left);
			}
			return null;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insertRoot(item);
		
		
		
		

	}

}
