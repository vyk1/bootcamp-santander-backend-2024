import java.util.InputMismatchException;
import java.util.Scanner;

public class ByteBank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = 0;
        String agencia = "";
        String nomeCliente = "";
        double saldo = 0.0;

        try {
            System.out.println("Por favor, digite o número da conta:");
            numero = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para o número da conta.");
            System.out.println("Ocorreu um erro ao tentar criar a conta. Por favor, tente novamente.");
            scanner.close();
        }

        try {
            System.out.println("Por favor, digite o número da agência:");
            agencia = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Entrada inválida para o número da agência.");
            System.out.println("Ocorreu um erro ao tentar criar a conta. Por favor, tente novamente.");
            scanner.close();
        }

        try {
            System.out.println("Por favor, digite o nome do cliente:");
            nomeCliente = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Entrada inválida para o nome do cliente.");
            System.out.println("Ocorreu um erro ao tentar criar a conta. Por favor, tente novamente.");
            scanner.close();
        }

        try {
            System.out.println("Por favor, digite o saldo da conta:");
            saldo = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida para o saldo.");
            System.out.println("Ocorreu um erro ao tentar criar a conta. Por favor, tente novamente.");
            scanner.close();
        }

        String mensagem = String.format(
                "Olá %s, obrigade por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo $%.2f já está disponível para saque.",
                nomeCliente, agencia, numero, saldo);
        System.out.println(mensagem);
    }
}