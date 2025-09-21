import java.math.BigDecimal;

public class Produto implements Identificavel<Integer> {
    private final Integer id;
    private final String nome;
    private final BigDecimal preco;

    public Produto(Integer id, String nome, BigDecimal preco) {
        if (id == null) throw new IllegalArgumentException("ID não pode ser nulo.");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido.");
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Preço inválido.");

        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{id=" + id + ", nome='" + nome + "', preco=" + preco + "}";
    }
}
