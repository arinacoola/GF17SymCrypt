public class Main {
    public static void main(String[] args) {
        int[] f=VectorBooleanFunc.buildF();
        int[][] fBits = CoordinateFunc.decompose(f);
        int x = 12345;
        int restored= 0;
        for (int i = 0;i < 17;i++){
            restored |= fBits[i][x]<< i;
        }
        System.out.println("f[x] = " + f[x]);
        System.out.println("restored = "+restored);
        if (f[x] == restored){
            System.out.println("одаддададададад");
        }
        else {
            System.out.println("нононо");
        }
    }


}
