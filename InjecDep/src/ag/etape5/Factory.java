package ag.etape5;

public class Factory {
	private boolean bool;

	public Factory() throws Exception {
		Package p = this.getClass().getPackage();
		System.out.println(p.getName());
		Class<?> c = Class.forName(p.getName() + ".B"); //permet de récupérer une classe à partir de son nom
		I i=(I) c.newInstance();
		A a = new A(i);
		bool = a.m();
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}
}
