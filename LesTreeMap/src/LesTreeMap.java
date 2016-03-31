import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class LesTreeMap {

	public static void main(String[] args) {
		LesTreeMap m = new LesTreeMap();
		m.init();
	}

	public void init() {

		ArrayList<String> a = new ArrayList<String>();

		int[] nb = { 1, 3, 6, 8 };
		String[] sNB = { "un", "trois", "six", "huit" };
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		for (int i = 0; i < sNB.length; i++) {
			map.put(Integer.valueOf(nb[i]), sNB[i]);
		}
		Set<Entry<Integer, String>> s = map.entrySet();
		for (Entry<Integer, String> entry : s) {
			Integer index = entry.getKey();
			String string = entry.getValue();
			int toto = 0;
		}
	}
}
