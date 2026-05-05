public class Main {
    public static void main(String[] args) {
        int x=12345;
        int f=GF17.pow(x,131070);
        int g=GF17.pow(x,131069);
        System.out.println(f);
        System.out.println(g);
        System.out.println(GF17.mul(5, 7));
        System.out.println(GF17.mul(7, 5));
    }
}