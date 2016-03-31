package ag.codility;

public class Main {


    public static void main(String[] args) {
        Main m = new Main();
        m.init();
    }
        private void init () {

            int[]a={1, 3, 1, 4, 2, 3, 5, 4};
            System.out.println(solution(5, a));
        }

    public int solution(int X, int[] A) {
        int n = -1;
        boolean[] pos = new boolean[X];
        int j = 1;
        z:
        for (int i = 0; i < A.length; i++) {
            pos[A[i] - 1] = true;
            if (A[i] == j) {
                while (pos[j - 1]) {
                    if (j == X) {
                        n = i;
                        break z;
                    }
                    j++;
                }
            }
        }
        return n;
    }
}

