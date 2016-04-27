package ag.etape6;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Factory {
	private boolean bool;

	public Factory() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("etape6/Factory.props")));
		Package p = this.getClass().getPackage();
		String nomClasse=p.getName()+"."+prop.getProperty("implementation_i_class");
		
		Class<?> d = Class.forName(nomClasse); // permet de récupérer
														// une classe à partir
														// de son nom
		I i = (I) d.newInstance();
		A a = new A(i);
		a.m();
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}
}
