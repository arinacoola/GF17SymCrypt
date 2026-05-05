public class VectorBooleanFunc {
    private static final int N = 17;
    private static final int fieldSize= 1<< N;

    public static int[] buildF() {
        int[] table=new int[fieldSize];
        for (int x = 0; x < fieldSize; x++){
            table[x]=GF17.pow(x,131070);
        }
        return table;
    }

    public static int[] buildG() {
        int[] table = new int[fieldSize];
        for (int x = 0;x < fieldSize;x++){
            table[x] =GF17.pow(x,131069);
        }
        return table;
    }
}
