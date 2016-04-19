package ag.main;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Reveil extends Thread {

	public boolean b = false;

	public void run() {

		InputStreamReader buf = new InputStreamReader(System.in);
		LineNumberReader line = new LineNumberReader(buf);
		String a = null;
try {
	Thread.sleep(100);
} catch (InterruptedException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
		while (!b) {
			
			System.out.println("appuyez sur ENTRER");
			try {
				a = line.readLine();
				System.out.println("Debout");
				synchronized (this){
					notify();
				}
			} catch (IOException e) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
System.out.println("Fin de reveil");
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}
}
