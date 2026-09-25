public class Entregador {
    private String nome;
    private String telefone;

    public Entregador(String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void realizarEntrega(Pedido pedido) {
        if (pedido == null || pedido.getEntregador() != this) {
            throw new IllegalStateException("Entregador não atribuído ao pedido");
        }
        pedido.entregar();
    }
}
