public class TesteThrow {
    public static void main(String[] args) {
        verificarIdade(28);
        System.out.println("Cadastro realizado!");
    }

    public static void verificarIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Idade mínima é 18 anos!");
        }
        System.out.println("Idade válida!");
    }

}
