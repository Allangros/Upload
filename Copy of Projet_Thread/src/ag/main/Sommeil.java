package ag.main;

import java.text.DecimalFormat;

public class Sommeil extends Thread {

	public Sommeil() {
	}

	@Override
	public void run() {

		Reveil treveil = new Reveil();
		treveil.start();
		long t = System.nanoTime();
		for (int i = 0; i < 20; i++) {

			synchronized (treveil) {
				try {
					treveil.wait();
				} catch (InterruptedException e) {

				}
				System.out.println("J'ai dormis " + difToString(t, System.nanoTime()));
				t = System.nanoTime();
			}
		}
		treveil.setB(true);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("arret Sommeil");
	}

	private String difToString(long avant, long apres) {
		double dif = ((double) apres - avant) / 1000000;
		DecimalFormat df = new DecimalFormat("#####.00");
		return df.format(dif) + " ms";
	}
}
