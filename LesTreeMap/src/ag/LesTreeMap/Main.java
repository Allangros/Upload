package ag.LesTreeMap;


import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.init();
    }

    public void init() {
        int[] nb = {1, 3, 6, 8};
        String[] snb = {"un", "trois", "six", "huit"};
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        for (int i = 0; i < snb.length; i++) {
            map.put(Integer.valueOf(nb[i]), snb[i]);
        }
        Set<Entry<Integer, String>> s = map.entrySet();
        for (Entry<Integer, String> entry : s) {
            Integer index = entry.getKey();
            String chaine = entry.getValue();
            System.out.println(index + " " + chaine);
        }

    }

}
