public class Main {
    public static void main(String[] args) {
        int[] f=VectorBooleanFunc.buildF();
        int[] g = VectorBooleanFunc.buildG();
        int[][] fBits =CoordinateFunc.decompose(f);
        int[][] gBits = CoordinateFunc.decompose(g);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        long startDeg =System.nanoTime();
        int[] fDeg = BooleanProp.allAlgebraDeg(fBits);
        int[] gDeg = BooleanProp.allAlgebraDeg(gBits);
        long endDeg = System.nanoTime();
        System.out.println("алгебраїчний степінь координат f:");
        for (int i = 0; i < 17;i++){
            System.out.println("f" + (i+1) +": "+ fDeg[i]);
        }
        System.out.println("алгебраїчний степінь координат g:");
        for (int i = 0;i < 17;i++) {
            System.out.println("g" + (i+1) +": "+ gDeg[i]);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("алгебраїчний степінь f в цілому: " + BooleanProp.vectorAlgebraDeg(fBits));
        System.out.println("алгебраїчний степінь g в цілому: " + BooleanProp.vectorAlgebraDeg(gBits));
        double degTime = (endDeg - startDeg)/1_000_000_000.0;
        System.out.printf("час обчислення алгебраїчного степеня: %.3f с%n", degTime);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        long startDis=System.nanoTime();
        int[] fDis=BooleanProp.allDisbalance(fBits);
        int[] gDis = BooleanProp.allDisbalance(gBits);
        long endDis = System.nanoTime();
        System.out.println("дисбаланс f:");
        for (int i = 0;i < 17;i++) {
            System.out.println("f" + (i+1)+": "+ fDis[i]);
        }
        System.out.println("дисбаланс g:");
        for (int i = 0; i < 17; i++) {
            System.out.println("g" + (i+1) + ": "+ gDis[i]);
        }
        double disTime = (endDis-startDis)/1_000_000_000.0;
        System.out.printf("час обчислення дисбалансу: %.3f с%n", disTime);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        long startNl=System.nanoTime();
        int[] fNl = BooleanProp.allNonlinearities(fBits);
        int[] gNl = BooleanProp.allNonlinearities(gBits);
        long endNl = System.nanoTime();
        System.out.println("нелінійність f:");
        for (int i = 0;i<17;i++){
            System.out.println("f" + (i+ 1)+ ": " + fNl[i]);
        }
        System.out.println("нелінійність g:");
        for (int i = 0; i < 17;i++) {
            System.out.println("g" +(i +1) + ": " + gNl[i]);
        }
        double nlTime = (endNl-startNl)/1_000_000_000.0;
        System.out.printf("час обчислення нелінійності: %.3f с%n", nlTime);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        long startCi =System.nanoTime();
        int[] fCi=BooleanProp.allCorrelationImmunity(fBits);
        int[] gCi = BooleanProp.allCorrelationImmunity(gBits);
        long endCi =System.nanoTime();
        System.out.println("кореляційний імунітет f:");
        for (int i = 0; i < 17;i++){
            System.out.println("f" + (i + 1) + ": " + fCi[i]);
        }
        System.out.println("кореляційний імунітет g:");
        for (int i = 0; i < 17; i++) {
            System.out.println("g" + (i + 1) + ": " + gCi[i]);
        }
        double ciTime = (endCi - startCi) /1_000_000_000.0;
        System.out.printf("час обчислення кореляційного імунітету: %.3f с%n", ciTime);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        long startAval=System.nanoTime();
        int[][] fAval = BooleanProp.allAvalanche(fBits);
        int[][] gAval=BooleanProp.allAvalanche(gBits);
        long endAval = System.nanoTime();
        System.out.println("лавинний ефект f:");
        for (int coord = 0;coord < 17;coord++){
            System.out.print("f" +(coord+1)+": ");
            for (int i = 0;i < 17;i++){
                System.out.print(fAval[coord][i] + " ");
            }
            System.out.println();
        }
        System.out.println("лавинний ефект g:");
        for (int coord=0;coord<17;coord++){
            System.out.print("g"+(coord+1) + ": ");
            for (int i = 0; i < 17; i++) {
                System.out.print(gAval[coord][i] + " ");
            }
            System.out.println();
        }
        double avalTime =(endAval- startAval) / 1_000_000_000.0;
        System.out.printf("час обчислення лавинного ефекту: %.3f с%n", avalTime);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        long startAvg= System.nanoTime();
        int[] fAvg = BooleanProp.avgAvalanche(f);
        int[] gAvg = BooleanProp.avgAvalanche(g);
        long endAvg = System.nanoTime();
        System.out.println("середній лавинний ефект f:");
        for (int i = 0; i < 17; i++) {
            System.out.println("f" + (i + 1) + ": " + fAvg[i]);
        }
        System.out.println("середній лавинний ефект g:");
        for (int i =0;i < 17;i++){
            System.out.println("g" + (i + 1) + ": " + gAvg[i]);
        }
        double avgTime =(endAvg- startAvg)/1_000_000_000.0;
        System.out.printf("час обчислення середнього лавинного ефекту: %.3f с%n", avgTime);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        long startDev = System.nanoTime();
        double[][] fDev = BooleanProp.avalancheDeviationPercent(fBits);
        double[][] gDev = BooleanProp.avalancheDeviationPercent(gBits);
        long endDev=System.nanoTime();
        System.out.println("відхилення лавинних коефіцієнтів f, %:");
        for (int coord= 0; coord < 17; coord++) {
            System.out.print("f" + (coord + 1) + ": ");
            for (int i = 0; i < 17;i++) {
                System.out.printf("%.2f ",fDev[coord][i]);
            }
            System.out.println();
        }
        System.out.println("відхилення лавинних коефіцієнтів g, %:");
        for (int coord = 0; coord< 17;coord++){
            System.out.print("g" + (coord + 1) +": ");
            for (int i = 0; i < 17; i++) {
                System.out.printf("%.2f ",  gDev[coord][i]);
            }
            System.out.println();
        }
        double devTime = (endDev- startDev) / 1_000_000_000.0;
        System.out.printf("час обчислення відхилень лавинних коефіцієнтів: %.3f с%n", devTime);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        double[] fAvgDev=BooleanProp.avgAvalancheDeviationPercent(f);
        double[] gAvgDev = BooleanProp.avgAvalancheDeviationPercent(g);
        System.out.println("відхилення середніх лавинних коефіцієнтів f, %:");
        for (int i =0;i < 17; i++) {
            System.out.printf("f%d: %.2f\n", i + 1, fAvgDev[i]);
        }
        System.out.println("відхилення середніх лавинних коефіцієнтів g, %:");
        for (int i = 0;i< 17; i++) {
            System.out.printf("g%d: %.2f\n",i + 1, gAvgDev[i]);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("лавинний ефект нульового рівня f: " + BooleanProp.hasAvalancheZeroLvl(fBits));
        System.out.println("лавинний ефект нульового рівня g: " + BooleanProp.hasAvalancheZeroLvl(gBits));
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("строгий лавинний ефект в середньому f: " + BooleanProp.hasStrictAvalancheAverage(f));
        System.out.println("строгий лавинний ефект в середньому g: " + BooleanProp.hasStrictAvalancheAverage(g));
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        long startMdp=System.nanoTime();
        double fMdp = BooleanProp.maxDifferentialP(f);
        double gMdp = BooleanProp.maxDifferentialP(g);
        long endMdp=System.nanoTime();
        System.out.printf("MDP f: %.10f\n", fMdp);
        System.out.printf("MDP g: %.10f\n",gMdp);
        double mdpTime = (endMdp - startMdp)/1_000_000_000.0;
        System.out.printf("час обчислення MDP: %.3f с%n", mdpTime);
    }
}