public class Teste {
    static void main() {
        int num = 10 / 10; // causa ArithmeticException
        System.out.println("Resultado: " + num);


        Conversor c1 = new Conversor();
        c1.n1 = "12s";
        c1.converter();
    }
}
