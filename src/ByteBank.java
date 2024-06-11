import java.util.Scanner;

public class ByteBank {
    public static void main(String[] args) {
        // Criar um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitar e ler o número da conta
        System.out.println("Por favor, digite o número da conta:");
        int numero = scanner.nextInt();

        // Limpar o buffer do scanner
        scanner.nextLine();

        // Solicitar e ler o número da agência
        System.out.println("Por favor, digite o número da agência:");
        String agencia = scanner.nextLine();

        // Solicitar e ler o nome do cliente
        System.out.println("Por favor, digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();

        // Solicitar e ler o saldo da conta
        System.out.println("Por favor, digite o saldo da conta:");
        double saldo = scanner.nextDouble();

        // Exibir a mensagem formatada
        String mensagem = String.format(
                "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.",
                nomeCliente, agencia, numero, saldo);

        System.out.println(mensagem);

        // Fechar o scanner
        scanner.close();
    }
}
