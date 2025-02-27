public class Recursion {
    public static void main(String[] args) {
        System.out.println(multi(2,3));
    }
    int multi (int a, int b) {
        if ((a | b) == 0) return 0;
        if (a == 1) return b;
        if (b == 1) return a;
        return multi_tail(a,b,0,b);
    }
    int multi_tail (int a, int b, int total, int retornos) {
        if (retornos > 0) return multi_tail(a,b,total + a,retornos - 1);
        return total;
    }
}