package ag.main;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.init();
	}
	public void init(){
		Sommeil tsommeil=new Sommeil();
		tsommeil.start();		
	}

}
