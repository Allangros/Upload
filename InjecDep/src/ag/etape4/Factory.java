package ag.etape4;

public class Factory {
	private boolean res;
	
	public Factory() {
		A a = new A(new B());
		System.out.println(a.m());
	}
	public boolean isRes(){
		return res;
	}
	public void setRes(boolean res){
		this.res=res;
	}
}
