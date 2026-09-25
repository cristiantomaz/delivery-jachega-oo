public abstract class Cliente {
    private String nome;
    private String telefone;
    private String endereco;

    public Cliente(String nome, String telefone, String endereco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public abstract double taxaEntrega(double valorItens, double taxaBase);
}
