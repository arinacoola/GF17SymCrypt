public class CoordinateFunc {
    private static final int N = 17;
    private static final int fieldSize=1<< N;

    public static int[][] decompose(int[] table) {
        int[][] bits=new int[N][fieldSize];
        for (int x = 0;x < fieldSize;x++) {
            int val = table[x];
            for (int i = 0;i < N; i++) {
                bits[i][x] =(val>>i) & 1;
            }
        }
        return bits;
    }
}
