public class Principal {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante("Cozinha da Vila", "Rua Central, 10");
        Prato prato = new Prato("Marmita", 30.00);
        restaurante.adicionarPrato(prato);
        Entregador entregador = new Entregador("Ana", "11999990000");

        Cliente comum = new ClienteComum("João", "11911110000", "Rua A");
        Cliente assinante = new ClienteAssinante("Maria", "11922220000", "Rua B", 50.00);
        Pedido pedidoComum = new Pedido(comum, restaurante, 8.00);
        pedidoComum.adicionarItem(prato, 1);
        Pedido pedidoAssinante = new Pedido(assinante, restaurante, 8.00);
        pedidoAssinante.adicionarItem(prato, 2);

        System.out.println("Comum: taxa R$ " + pedidoComum.getTaxaEntrega()
                + ", total R$ " + pedidoComum.calcularTotal());
        System.out.println("Assinante: taxa R$ " + pedidoAssinante.getTaxaEntrega()
                + ", total R$ " + pedidoAssinante.calcularTotal());

        pedidoAssinante.atribuirEntregador(entregador);
        pedidoAssinante.iniciarPreparo();
        pedidoAssinante.sairParaEntrega();
        entregador.realizarEntrega(pedidoAssinante);
        System.out.println("Status final: " + pedidoAssinante.getStatus());

        try {
            pedidoComum.atribuirEntregador(entregador);
            pedidoComum.atribuirEntregador(new Entregador("Carlos", "11933330000"));
        } catch (IllegalStateException erro) {
            System.out.println("Regra protegida: " + erro.getMessage());
        }
    }
}
