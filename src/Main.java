public class Main {
    public static void main(String[] args) {
        int[] f=VectorBooleanFunc.buildF();
        int[] g = VectorBooleanFunc.buildG();
        int[][] fBits =CoordinateFunc.decompose(f);
        int[][] gBits = CoordinateFunc.decompose(g);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        int[] fDeg = BooleanProp.allAlgebraDeg(fBits);
        int[] gDeg = BooleanProp.allAlgebraDeg(gBits);
        System.out.println("алгебраїчний степінь координат f:");
        for (int i = 0; i < 17; i++) {
            System.out.println("f" + (i + 1) + ": " + fDeg[i]);
        }
        System.out.println("алгебраїчний степінь координат g:");
        for (int i = 0; i < 17; i++) {
            System.out.println("g" + (i + 1) + ": " + gDeg[i]);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("алгебраїчний степінь f в цілому: " + BooleanProp.vectorAlgebraDeg(fBits));
        System.out.println("алгебраїчний степінь g в цілому: " + BooleanProp.vectorAlgebraDeg(gBits));
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
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
        System.out.println("-----------------------------------------------------------------------------------------------------");
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
        System.out.println("-----------------------------------------------------------------------------------------------------");
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
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
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
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        int[] fAvg=BooleanProp.avgAvalanche(f);
        int[] gAvg =BooleanProp.avgAvalanche(g);
        System.out.println("середній лавинний ефект f: ");
        for (int i = 0; i < 17; i++){
            System.out.println("f"+ (i + 1) + ": " + fAvg[i]);
        }
        System.out.println("середній лавинний ефект g: ");
        for (int i = 0; i < 17; i++){
            System.out.println("g"+ (i + 1) + ": " + gAvg[i]);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        double[][] fDev = BooleanProp.avalancheDeviationPercent(fBits);
        double[][] gDev = BooleanProp.avalancheDeviationPercent(gBits);
        System.out.println("відхилення лавинних коефіцієнтів f, %:");
        for (int coord = 0; coord < 17; coord++) {
            System.out.print("f" + (coord + 1) + ": ");
            for (int i = 0; i < 17; i++) {
                System.out.printf("%.2f ", fDev[coord][i]);
            }
            System.out.println();
        }
        System.out.println("відхилення лавинних коефіцієнтів g, %:");
        for (int coord = 0; coord < 17; coord++) {
            System.out.print("g" + (coord + 1) + ": ");
            for (int i = 0; i < 17; i++) {
                System.out.printf("%.2f ", gDev[coord][i]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        double[] fAvgDev = BooleanProp.avgAvalancheDeviationPercent(f);
        double[] gAvgDev = BooleanProp.avgAvalancheDeviationPercent(g);
        System.out.println("відхилення середніх лавинних коефіцієнтів f, %:");
        for (int i = 0; i < 17; i++) {
            System.out.printf("f%d: %.2f\n", i + 1, fAvgDev[i]);
        }
        System.out.println("відхилення середніх лавинних коефіцієнтів g, %:");
        for (int i = 0; i < 17; i++) {
            System.out.printf("g%d: %.2f\n", i + 1, gAvgDev[i]);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("лавинний ефект нульового рівня f: " + BooleanProp.hasAvalancheZeroLvl(fBits));
        System.out.println("лавинний ефект нульового рівня g: " + BooleanProp.hasAvalancheZeroLvl(gBits));
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("строгий лавинний ефект в середньому f: " + BooleanProp.hasStrictAvalancheAverage(f));
        System.out.println("строгий лавинний ефект в середньому g: " + BooleanProp.hasStrictAvalancheAverage(g));
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        double fMdp =BooleanProp.maxDifferentialP(f);
        double gMdp = BooleanProp.maxDifferentialP(g);
        System.out.printf("MDP f: %.10f\n", fMdp);
        System.out.printf("MDP g: %.10f\n", gMdp);
    }

}


