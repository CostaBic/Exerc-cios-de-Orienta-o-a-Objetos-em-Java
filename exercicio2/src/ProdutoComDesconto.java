public class ProdutoComDesconto extends Produto {

    public ProdutoComDesconto(String nome, double preco, int quantidadeEmEstoque) {
        super(nome, preco, quantidadeEmEstoque);
    }

    // Método aplicar desconto (0 a 50%)
    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) {
            throw new DescontoInvalidoException("Desconto inválido: deve estar entre 0% e 50%.");
        }
        double desconto = getPreco() * (porcentagem / 100);
        setPreco(getPreco() - desconto);
    }
}
