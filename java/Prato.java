public class Prato {
    private String nome;
    private double preco;

    public Prato(String nome, double preco) {
        if (nome == null || nome.trim().isEmpty() || preco < 0) {
            throw new IllegalArgumentException("Prato inválido");
        }
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double obterPreco() {
        return preco;
    }
}
