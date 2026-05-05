public class GF17 {
    private static final int N = 17;
    private static final int fieldSize = 1 << N;
    private static final int poly = (1 << 17) | (1 << 3) | 1;

    public static int add(int u, int v ) {
        return u ^ v;
    }

    public static int mul(int u,int v) {
        int res= 0;
        while (v!= 0) {
            if ((v & 1) != 0) {
                res^= u;
            }
            v>>= 1;
            u<<= 1;
            if ((u &fieldSize)!= 0) {
                u^= poly;
            }
        }
        return res& (fieldSize- 1);
    }

    public static int pow(int u, int exp) {
        int res=1;
        int base = u;
        while (exp>0){
            if ((exp & 1)!= 0){
                res= mul(res,base);
            }
            base=mul(base,base);
            exp >>= 1;
        }
        return res;
    }

}

