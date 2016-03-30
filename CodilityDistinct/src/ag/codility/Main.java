package ag.codility;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.init();
    }

    public int init() {
        ArrayList<Integer> list = new ArrayList<>();
        int nombre=0;
        int[] tab = {2, 1, 1, 2, 3, 1};
        for (int i = 0; i < tab.length; i++) {
            if (list.contains(tab[i])) {
            } else {
                list.add(tab[i]);
            }
            nombre = list.size();
        }
        System.out.println(nombre);
        return nombre;
    }
}
