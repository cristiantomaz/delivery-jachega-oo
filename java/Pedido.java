import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private Restaurante restaurante;
    private Entregador entregador;
    private List<ItemPedido> itens;
    private double taxaBase;
    private double taxaEntrega;
    private double total;
    private String status;

    public Pedido(Cliente cliente, Restaurante restaurante, double taxaBase) {
        if (cliente == null || restaurante == null || taxaBase < 0) {
            throw new IllegalArgumentException("Dados do pedido inválidos");
        }
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.taxaBase = taxaBase;
        this.itens = new ArrayList<ItemPedido>();
        this.status = "RECEBIDO";
        atualizarTotal();
    }

    public void adicionarItem(Prato prato, int quantidade) {
        exigirStatus("RECEBIDO");
        if (!restaurante.contemPrato(prato)) {
            throw new IllegalArgumentException("Prato não pertence ao restaurante");
        }
        itens.add(new ItemPedido(prato, quantidade));
        atualizarTotal();
    }

    private void atualizarTotal() {
        double valorItens = 0;
        for (ItemPedido item : itens) {
            valorItens += item.calcularSubtotal();
        }
        taxaEntrega = cliente.taxaEntrega(valorItens, taxaBase);
        if (taxaEntrega < 0) {
            throw new IllegalStateException("Taxa de entrega negativa");
        }
        total = valorItens + taxaEntrega;
    }

    public void atribuirEntregador(Entregador novoEntregador) {
        if (novoEntregador == null || entregador != null || status.equals("CANCELADO")
                || status.equals("ENTREGUE")) {
            throw new IllegalStateException("Entregador inválido ou já atribuído");
        }
        entregador = novoEntregador;
    }

    public void iniciarPreparo() {
        exigirStatus("RECEBIDO");
        if (itens.isEmpty()) {
            throw new IllegalStateException("Pedido sem itens");
        }
        status = "PREPARANDO";
    }

    public void sairParaEntrega() {
        exigirStatus("PREPARANDO");
        if (entregador == null) {
            throw new IllegalStateException("Pedido sem entregador");
        }
        status = "A_CAMINHO";
    }

    public void entregar() {
        exigirStatus("A_CAMINHO");
        status = "ENTREGUE";
    }

    public void cancelar() {
        if (status.equals("ENTREGUE") || status.equals("CANCELADO")) {
            throw new IllegalStateException("Pedido não pode ser cancelado");
        }
        status = "CANCELADO";
        itens.clear();
        taxaEntrega = 0;
        total = 0;
    }

    private void exigirStatus(String esperado) {
        if (!status.equals(esperado)) {
            throw new IllegalStateException("Esperado " + esperado + ", mas está " + status);
        }
    }

    public double calcularTotal() {
        return total;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public String getStatus() {
        return status;
    }

    public Entregador getEntregador() {
        return entregador;
    }
}
