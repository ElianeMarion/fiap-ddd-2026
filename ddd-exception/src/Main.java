//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    try {
        int num = 10 / 0; // causa ArithmeticException
        System.out.println("Resultado: " + num);

        Conversor c1 = new Conversor();
        c1.n1 = "12s";
        c1.converter();

    } catch (ArithmeticException e) {

        System.out.println("Erro: divisão por zero não permitida!");
    } catch (NumberFormatException e) {
        System.out.println("Valor informado não é um número");
    } catch (RuntimeException e) {
        System.out.println("Erro na aplicação");
    }
}

