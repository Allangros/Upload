package Codility;

public class Factor {

	public static void main(String[] args) {
		int numFac = 24;

		int factorCpt = 0;
		for (int i = 1; i <= numFac; i++) {
			if (numFac % i == 0) {
				factorCpt++;
			}
		}
	}
}