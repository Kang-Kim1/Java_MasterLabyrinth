package prac.LR;

import java.util.HashSet;

import prac.LR.LRStruct.IAlgo;

public class ExamVisitor implements IAlgo<HashSet<String>, String, Integer> {

	@Override
	public HashSet<String> emptyCase(LRStruct<String> host, Integer arg) {
		return new HashSet<String>();
	}

	@Override
	public HashSet<String> nonEmptyCase(LRStruct<String> host, Integer arg) {
		HashSet<String> toReturn;
		toReturn = host.getRest().execute(this, arg);

		if (host.getDatum().length() < arg) {
			toReturn.add(host.getDatum());
		}

		return toReturn;
	}

	public static void main(String[] args) {

		LRStruct<String> lr = new LRStruct<String>();
		lr.insertFront("열네글자0000000000").insertFront("일곱글자000")
				.insertFront("다섯글자0").insertFront("세글자");

		HashSet<String> s = lr.execute(new ExamVisitor(), 5);

		System.out.println(s);
	}

}
