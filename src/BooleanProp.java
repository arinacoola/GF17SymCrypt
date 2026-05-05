public class BooleanProp {
    private static final int N=17;
    private static final int fieldSize = 1 << N;

    public static int disbalance(int[] func){
        int zeros = 0;
        int ones =0;
        for (int x = 0; x < fieldSize;x++) {
            if (func[x]== 0) {
                zeros++;
            }
            else {
                ones++;
            }
        }
        return zeros- ones;
    }

    public static int[] allDisbalance(int[][] func) {
        int[] res=new int[N];
        for (int i = 0; i < N; i++) {
            res[i]=disbalance(func[i]);
        }
        return res;
    }
}
