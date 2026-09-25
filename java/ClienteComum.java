public class ClienteComum extends Cliente {
    public ClienteComum(String nome, String telefone, String endereco) {
        super(nome, telefone, endereco);
    }

    @Override
    public double taxaEntrega(double valorItens, double taxaBase) {
        return taxaBase;
    }
}
