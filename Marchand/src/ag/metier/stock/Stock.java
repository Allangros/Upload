package ag.metier.stock;

import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import ag.metier.produit.Produit;

public class Stock extends TreeMap<String, Produit> {

	public Stock() {

	}

	@Override
	public String toString() {
		
	Set<Entry<String, Produit>> set = this.entrySet();
	String s="[";
	for (Entry<String, Produit> entry : set) {
		s=s+" "+entry.getValue().toString()+", ";
	}
	s+="]";

		return s;
	}

}

