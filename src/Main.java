public class Main {
    public static void main(String[] args) {
        int[] f=VectorBooleanFunc.buildF();
        int[] g = VectorBooleanFunc.buildG();
        System.out.println(f[0]);
        System.out.println(f[1]);
        System.out.println(f[12345]);
        System.out.println(g[0]);
        System.out.println(g[1]);
        System.out.println(g[12345]);
    }
}