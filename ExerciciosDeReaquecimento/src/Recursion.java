import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(multi(5,3));
        System.out.println(soma(5,3));
        System.out.println(calculo(2));
        System.out.println(inversao("bom dia"));
    }
    // - Multiplicação de dois números naturais, através de somas sucessivas (Ex.: 6 ∗ 4 = 4 + 4 + 4 + 4 + 4 + 4).
    static int multi(int a, int b) {
        if ((a | b) == 0) return 0;
        if (a == 1) return b;
        if (b == 1) return a;
        return multi_tail(a,b,0,b);
    }
    static int multi_tail(int a, int b, int total, int retornos) {
        if (retornos > 0) return multi_tail(a,b,total + a,retornos - 1);
        return total;
    }
    // - Soma de dois números naturais, através de incrementos sucessivos (Ex.: 3 + 2 = + + (+ + + 1)).
    static int soma(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return soma_tail(0,a + b);
    }
    static int soma_tail(int total, int retornos) {
        if (retornos > 0) return soma_tail(total + 1, retornos - 1);
        return total;
    }
    // - Cálculo de 1 + 1/2 + 1/3 + 1/4 + ... + 1/N.
    static double calculo(double n) {
        return calculo_tail(0,n);
    }
    static double calculo_tail(double total, double n) {
        if (n > 0) return calculo_tail(total + (1/n), n - 1);
        return total;
    }
    // - Inversão de uma string.
    static String inversao(String s) {
        return inversao_tail(s.toCharArray(), s.length(),new char[s.length()]);
    }
    static String inversao_tail(char[] array, int retornos, char[] chars) {
        if (retornos > 0) {
            chars[array.length - retornos] = array[retornos - 1];
            return inversao_tail(array, retornos - 1, chars);
            }
        return Arrays.toString(chars);
    }
}
