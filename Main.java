import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n=== Cadastro de Clientes ===");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = scanner.nextLine();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException erro) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, email, telefone);
                    clientes.add(cliente);

                    System.out.println("Cliente cadastrado!");
                    break;

                case 2:
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("\n--- Clientes cadastrados ---");

                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println("\nCliente " + (i + 1));
                            clientes.get(i).exibirDados();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
