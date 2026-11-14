import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ClienteService service = new ClienteService();

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> buscarCliente();
                case 4 -> atualizarCliente();
                case 5 -> removerCliente();
                case 0 -> System.out.println("Encerrando o sistema. Até logo!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE CADASTRO DE CLIENTES ===");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Buscar cliente por ID");
        System.out.println("4. Atualizar cliente");
        System.out.println("5. Remover cliente");
        System.out.println("0. Sair");
    }

    private static void cadastrarCliente() {
        System.out.println("\n--- Novo Cadastro ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        try {
            Cliente criado = service.cadastrar(nome, email, telefone);
            System.out.println("Cliente cadastrado com sucesso! -> " + criado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    private static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        List<Cliente> lista = service.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado no momento.");
            return;
        }
        for (Cliente c : lista) {
            System.out.println(c);
        }
    }

    private static void buscarCliente() {
        int id = lerInteiro("\nDigite o ID do cliente: ");
        Cliente cliente = service.buscarPorId(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("Cliente com ID " + id + " não encontrado.");
        }
    }

    private static void atualizarCliente() {
        int id = lerInteiro("\nDigite o ID do cliente que deseja atualizar: ");
        if (service.buscarPorId(id) == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();

        try {
            service.atualizar(id, nome, email, telefone);
            System.out.println("Dados atualizados com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    private static void removerCliente() {
        int id = lerInteiro("\nDigite o ID do cliente que deseja remover: ");
        if (service.remover(id)) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente com ID " + id + " não encontrado.");
        }
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite apenas números.");
            }
        }
    }
}
