public class Main {
    public static void main(String[] args) {
        int[] f=VectorBooleanFunc.buildF();
        int[] g = VectorBooleanFunc.buildG();
        /*int[][] fBits =CoordinateFunc.decompose(f);
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
        int[] walsh = WalshTransform.transform(fBits[0]);
        System.out.println(walsh[0]);
        int[] fNl = BooleanProp.allNonlinearities(fBits);
        int[] gNl = BooleanProp.allNonlinearities(gBits);
        System.out.println("нелінійність f:");
        for (int i = 0;i < 17; i++){
            System.out.println("f" +(i + 1) +": " + fNl[i]);
        }
        System.out.println("нелінійність g:");
        for (int i=0; i < 17; i++) {
            System.out.println("g"+ (i+1) + ": " + gNl[i]);
        }
        int[] fCi=BooleanProp.allCorrelationImmunity(fBits);
        int[] gCi = BooleanProp.allCorrelationImmunity(gBits);
        System.out.println("кореляційний імунітет f:");
        for (int i = 0;i < 17; i++) {
            System.out.println("f" + (i + 1) + ": " +fCi[i]);
        }
        System.out.println("кореляційний імунітет g:");
        for (int i = 0; i<17;i++) {
            System.out.println("g" + (i + 1) + ": " + gCi[i]);
        }
        int[][] fAval = BooleanProp.allAvalanche(fBits);
        int[][] gAval = BooleanProp.allAvalanche(gBits);
        System.out.println("лавинний ефект f:");
        for (int coord = 0; coord < 17;coord++) {
            System.out.print("f" + (coord + 1) + ": ");
            for (int i = 0; i < 17; i++) {
                System.out.print(fAval[coord][i] + " ");
            }
            System.out.println();
        }
        System.out.println("лавинний ефект g:");
        for (int coord = 0; coord < 17; coord++) {
            System.out.print("g" + (coord + 1) + ": ");
            for (int i = 0; i < 17; i++) {
                System.out.print(gAval[coord][i] + " ");
            }
            System.out.println();
        }
        int[] fAvg=BooleanProp.avgAvalanche(f);
        int[] gAvg =BooleanProp.avgAvalanche(g);
        System.out.println("середній лавинний ефект f: ");
        for (int i = 0; i < 17; i++){
            System.out.println("f"+ (i + 1) + ": " + fAvg[i]);
        }
        System.out.println("середній лавинний ефект g: ");
        for (int i = 0; i < 17; i++){
            System.out.println("g"+ (i + 1) + ": " + gAvg[i]);
        }*/
        double fMdp =BooleanProp.maxDifferentialP(f);
        double gMdp = BooleanProp.maxDifferentialP(g);
        System.out.printf("MDP f: %.10f\n", fMdp);
        System.out.printf("MDP g: %.10f\n", gMdp);

    }

}


