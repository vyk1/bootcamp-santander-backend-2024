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
            // Solicitar e ler o número da conta
            System.out.println("Por favor, digite o número da conta:");
            numero = scanner.nextInt();

            // Limpar o buffer do scanner
            scanner.nextLine();

            // Solicitar e ler o número da agência
            System.out.println("Por favor, digite o número da agência:");
            agencia = scanner.nextLine();

            // Solicitar e ler o nome do cliente
            System.out.println("Por favor, digite o nome do cliente:");
            nomeCliente = scanner.nextLine();

            // Solicitar e ler o saldo da conta
            System.out.println("Por favor, digite o saldo da conta:");
            saldo = scanner.nextDouble();

            // Exibir a mensagem formatada
            String mensagem = String.format(
                    "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.",
                    nomeCliente, agencia, numero, saldo);
            System.out.println(mensagem);

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira os dados no formato correto.");
        } catch (Exception e) {
            System.out.println("Erro: Ocorreu um problema inesperado. Por favor, tente novamente.");
        } finally {
            // Fechar o scanner
            scanner.close();
        }
    }
}