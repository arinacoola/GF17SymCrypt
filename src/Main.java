public class Main {
    public static void main(String[] args) {
        int[] f=VectorBooleanFunc.buildF();
        int[] g = VectorBooleanFunc.buildG();
        int[][] fBits =CoordinateFunc.decompose(f);
        int[][] gBits = CoordinateFunc.decompose(g);
        int[] fDis=BooleanProp.allDisbalance(fBits);
        int[] gDis =BooleanProp.allDisbalance(gBits);
        System.out.println("дисбаланс f:");
        for (int i = 0; i < 17; i++) {
            System.out.println("f" + (i + 1) +": " + fDis[i]);
        }
        System.out.println("дисбаланс g:");
        for (int i = 0; i < 17; i++) {
            System.out.println("g" + (i+1) + ": " + gDis[i]);
        }
    }
}


