public class ItemPedido {
    private Prato prato;
    private int quantidade;
    private double precoUnitario;

    // Criado somente pelo Pedido; não é compartilhado entre pedidos.
    ItemPedido(Prato prato, int quantidade) {
        if (prato == null || quantidade <= 0) {
            throw new IllegalArgumentException("Item inválido");
        }
        this.prato = prato;
        this.quantidade = quantidade;
        this.precoUnitario = prato.obterPreco();
    }

    public double calcularSubtotal() {
        return quantidade * precoUnitario;
    }

    public String getNomePrato() {
        return prato.getNome();
    }
}
