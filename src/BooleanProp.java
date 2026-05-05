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

    public static int nonlinearity(int[] walsh) {
        int max = 0;
        for (int i=0;i<walsh.length;i++) {
            int val=Math.abs(walsh[i]);
            if (val > max) {
                max = val;
            }
        }
        return (1 << 16) - max/2;
    }

    public static int[] allNonlinearities(int[][] func) {
        int[] res=new int[17];
        for (int i= 0; i < 17;i++) {
            int[] walsh = WalshTransform.transform(func[i]);
            res[i] =nonlinearity(walsh);
        }
        return res;
    }

    public static int correlationImmunity(int[] walsh) {
        int k =0;
        for (int t = 1;t <= 17; t++){
            boolean ok = true;
            for (int a = 1; a < walsh.length; a++) {
                if (Integer.bitCount(a)== t) {
                    if (walsh[a]!= 0) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                k=t;
            }
            else {
                break;
            }
        }
        return k;
    }

    public static int[] allCorrelationImmunity(int[][] func) {
        int[] res = new int[17];
        for (int i = 0; i < 17; i++){
            int[] walsh=WalshTransform.transform(func[i]);
            res[i] =correlationImmunity(walsh);
        }
        return res;
    }

    public static int avalanche(int[] func,int i) {
        int size=func.length;
        int count = 0;
        for (int x = 0;x < size; x++) {
            int flip=x ^ (1 << i);
            if (func[x]!=func[flip]) {
                count++;
            }
        }
        return count;
    }

    public static int[][] allAvalanche(int[][] func){
        int[][] res = new int[17][17];
        for (int f = 0; f < 17; f++) {
            for (int i = 0;i < 17; i++) {
                res[f][i] = avalanche(func[f],i);
            }
        }
        return res;
    }

    public static int[] avgAvalanche(int[]  func) {
        int size=func.length;
        int[] res = new int[17];
        for (int i = 0; i < 17; i++){
            int sum = 0;
            for (int x = 0;x < size; x++) {
                int flip=x ^(1 << i);
                int diff = func[x] ^ func[flip];
                sum += Integer.bitCount(diff);
            }
            res[i] = sum;
        }
        return res;
    }

    public static double maxDifferentialP(int[] func) {
        int size=func.length;
        int[] count = new int[size];
        int maxCount =0;
        int a = 1;
        for (int x = 0;x < size;x++) {
            int diff =func[x]^func[x ^ a];
            count[diff]++;
            if (count[diff] > maxCount) {
                maxCount = count[diff];
            }
        }
        return maxCount/(double) size;
    }


}
