package ag.autres;

public class TestInteger {

	public static void main(String[] args) {
		TestInteger testInteger = new TestInteger();
		testInteger.init();
	}

	public void init() {

		int i = Integer.valueOf("257");
		System.out.println(i);

		String sI = Integer.toString(i);
		// Convertir chaîne de caractère en décimal
		System.out.println(sI);
		System.out.println(Integer.toHexString(i));
		System.out.println(Integer.toBinaryString(i));
		int j = new Integer(5).intValue();

		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);
		int a = 4;
		System.out.println(a);
		if (i1.equals(i2)) {
			System.out.println("Perdu");
		} else {
			System.out.println("gagné");
		}
		int k = i1.intValue();
		float f = i1.floatValue();
		int m = i1.parseInt("32");

	}

}
