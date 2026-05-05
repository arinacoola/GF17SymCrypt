public class WalshTransform {
    private static final int N = 17;
    private static final int fieldSize =1 <<N;

    public static int[] transform(int[] func) {
        int[] w=new int[fieldSize];
        for (int i = 0;i < fieldSize;i++) {
            w[i] =(func[i] == 0) ? 1 : -1;
        }
        for (int len = 1; len < fieldSize;len <<= 1) {
            for (int i = 0;i < fieldSize;i += 2 *len) {
                for (int j = 0; j < len;j++) {
                    int u = w[i + j];
                    int v = w[i + j+len];
                    w[i + j] = u +v;
                    w[i + j + len] = u-v;
                }
            }
        }
        return w;
    }
}
