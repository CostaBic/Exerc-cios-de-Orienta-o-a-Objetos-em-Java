import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Notebook", new Dinheiro(new BigDecimal("3500"), Moeda.BRL));
        Produto p2 = new Produto("Mouse", new Dinheiro(new BigDecimal("150"), Moeda.BRL));

        Carrinho carrinho = new Carrinho(List.of());
        carrinho = carrinho.adicionarItem(new ItemCarrinho(p1, 1));
        carrinho = carrinho.adicionarItem(new ItemCarrinho(p2, 2));

        System.out.println("Carrinho inicial:");
        carrinho.getItens().forEach(i ->
                System.out.println(i.getProduto().getNome() + " x" + i.getQuantidade() + " = " + i.getTotal())
        );
        System.out.println("Total original: " + carrinho.getTotalOriginal()); // BRL 3800.00

        // Aplicando cupom válido de 20%
        System.out.println("\nAplicando cupom de 20%:");
        Carrinho comDesconto = carrinho.aplicarCupom(new BigDecimal("20"));
        System.out.println("Total original: " + comDesconto.getTotalOriginal()); // BRL 3800.00
        System.out.println("Desconto (20%): " + comDesconto.getDescontoValor());   // BRL 760.00
        System.out.println("Total com desconto: " + comDesconto.getTotalComDesconto()); // BRL 3040.00

        // Testando cupom inválido
        System.out.println("\nAplicando cupom inválido de 50%:");
        try {
            carrinho.aplicarCupom(new BigDecimal("50"));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
