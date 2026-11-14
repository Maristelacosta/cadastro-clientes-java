
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;
    private static final String NOME_ARQUIVO = "clientes.csv";

    public ClienteService() {
        carregarDoArquivo();
    }

    public Cliente cadastrar(String nome, String email, String telefone) {
        if (buscarPorEmail(email) != null) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com este e-mail.");
        }
        Cliente novoCliente = new Cliente(proximoId++, nome, email, telefone);
        clientes.add(novoCliente);
        salvarNoArquivo();
        return novoCliente;
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    private Cliente buscarPorEmail(String email) {
        for (Cliente c : clientes) {
            if (c.getEmail().equalsIgnoreCase(email.trim())) {
                return c;
            }
        }
        return null;
    }

    public boolean atualizar(int id, String novoNome, String novoEmail, String novoTelefone) {
        Cliente cliente = buscarPorId(id);
        if (cliente == null) {
            return false;
        }

        Cliente clienteComMesmoEmail = buscarPorEmail(novoEmail);
        if (clienteComMesmoEmail != null && clienteComMesmoEmail.getId() != id) {
            throw new IllegalArgumentException("Este e-mail já está em uso por outro cliente.");
        }

        cliente.setNome(novoNome);
        cliente.setEmail(novoEmail);
        cliente.setTelefone(novoTelefone);
        salvarNoArquivo();
        return true;
    }

    public boolean remover(int id) {
        Cliente cliente = buscarPorId(id);
        if (cliente != null) {
            clientes.remove(cliente);
            salvarNoArquivo();
            return true;
        }
        return false;
    }

    private void salvarNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Cliente c : clientes) {
                writer.write(c.getId() + ";" + c.getNome() + ";" + c.getEmail() + ";" + c.getTelefone());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }

    private void carregarDoArquivo() {
        File arquivo = new File(NOME_ARQUIVO);
        if (!arquivo.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            int maiorId = 0;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    String email = partes[2];
                    String telefone = partes[3];

                    clientes.add(new Cliente(id, nome, email, telefone));
                    if (id > maiorId) {
                        maiorId = id;
                    }
                }
            }
            proximoId = maiorId + 1;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao carregar os dados do arquivo: " + e.getMessage());
        }
    }
}
