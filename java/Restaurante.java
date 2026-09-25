import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nome;
    private String endereco;
    private List<Prato> pratos;

    public Restaurante(String nome, String endereco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }
        this.nome = nome;
        this.endereco = endereco;
        this.pratos = new ArrayList<Prato>();
    }

    public void adicionarPrato(Prato prato) {
        if (prato == null || pratos.contains(prato)) {
            throw new IllegalArgumentException("Prato inválido ou já cadastrado");
        }
        pratos.add(prato);
    }

    public boolean contemPrato(Prato prato) {
        return pratos.contains(prato);
    }

    public String getNome() {
        return nome;
    }
}
