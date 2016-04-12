package Codility;

public class CodilityProfit {

	public static void main(String[] args) {
		CodilityProfit pro = new CodilityProfit();
		pro.init();
	}

	public int init() {
		int[] A = { 23171, 21011, 21123, 21366, 21013, 21367 };

		if (A.length == 0 || A.length == 1) {
			return 0;
		}
		int maxProfit = 0;
		int ProfitHere = 0;
		int MinPrice = A[0];
		for (int i = 0; i < A.length; i++) {
			ProfitHere = Math.max(0, A[i] - MinPrice);
			MinPrice = Math.min(MinPrice, A[i]);
			maxProfit = Math.max(ProfitHere, maxProfit);
		}

		return maxProfit;
	}

}
