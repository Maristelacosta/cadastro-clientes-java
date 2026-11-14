public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String telefone;

    // Construtor completo com ID (usado ao carregar do arquivo ou cadastrar)
    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ficar em branco.");
        }
        this.nome = nome.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        this.email = email.trim();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("O telefone não pode ficar em branco.");
        }
        this.telefone = telefone.trim();
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | E-mail: %s | Telefone: %s", id, nome, email, telefone);
    }
}
