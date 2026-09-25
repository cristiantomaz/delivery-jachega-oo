public class ClienteAssinante extends Cliente {
    private double valorMinimoEntregaGratis;

    public ClienteAssinante(String nome, String telefone, String endereco,
                            double valorMinimoEntregaGratis) {
        super(nome, telefone, endereco);
        if (valorMinimoEntregaGratis < 0) {
            throw new IllegalArgumentException("Mínimo não pode ser negativo");
        }
        this.valorMinimoEntregaGratis = valorMinimoEntregaGratis;
    }

    @Override
    public double taxaEntrega(double valorItens, double taxaBase) {
        if (valorItens >= valorMinimoEntregaGratis) {
            return 0;
        }
        return taxaBase;
    }
}
