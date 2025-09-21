import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal descontoPercentual; // percentual entre 0 e 30 inclusive

    public Carrinho(List<ItemCarrinho> itens) {
        this(itens, BigDecimal.ZERO);
    }

    public Carrinho(List<ItemCarrinho> itens, BigDecimal descontoPercentual) {
        if (itens == null) {
            throw new IllegalArgumentException("Lista de itens não pode ser nula.");
        }
        if (descontoPercentual == null) {
            descontoPercentual = BigDecimal.ZERO;
        }
        if (descontoPercentual.compareTo(BigDecimal.ZERO) < 0
                || descontoPercentual.compareTo(new BigDecimal("30")) > 0) {
            throw new IllegalArgumentException("Cupom inválido. O desconto máximo é 30%.");
        }
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.descontoPercentual = descontoPercentual;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    // Total sem desconto
    public Dinheiro getTotalOriginal() {
        Dinheiro total = new Dinheiro(BigDecimal.ZERO, Moeda.BRL);
        for (ItemCarrinho item : itens) {
            total = total.somar(item.getTotal());
        }
        return total;
    }

    // Valor do desconto calculado a partir do percentual
    public Dinheiro getDescontoValor() {
        if (descontoPercentual.compareTo(BigDecimal.ZERO) == 0) {
            return new Dinheiro(BigDecimal.ZERO, Moeda.BRL);
        }
        Dinheiro totalOriginal = getTotalOriginal();
        BigDecimal fator = descontoPercentual.divide(new BigDecimal("100"));
        return totalOriginal.multiplicar(fator); // Dinheiro já aplica scale HALF_EVEN no construtor
    }

    // Total após aplicar o desconto
    public Dinheiro getTotalComDesconto() {
        Dinheiro totalOriginal = getTotalOriginal();
        Dinheiro desconto = getDescontoValor();
        return totalOriginal.subtrair(desconto);
    }

    // Retorna novo carrinho com o item adicionado
    public Carrinho adicionarItem(ItemCarrinho item) {
        List<ItemCarrinho> novos = new ArrayList<>(this.itens);
        novos.add(item);
        return new Carrinho(novos, this.descontoPercentual);
    }

    // Retorna novo carrinho com o item removido
    public Carrinho removerItem(ItemCarrinho item) {
        List<ItemCarrinho> novos = new ArrayList<>(this.itens);
        novos.remove(item);
        return new Carrinho(novos, this.descontoPercentual);
    }

    // Retorna novo carrinho com o cupom aplicado (valida 0..30)
    public Carrinho aplicarCupom(BigDecimal percentual) {
        if (percentual == null) {
            throw new IllegalArgumentException("Percentual não pode ser nulo.");
        }
        if (percentual.compareTo(BigDecimal.ZERO) < 0 || percentual.compareTo(new BigDecimal("30")) > 0) {
            throw new IllegalArgumentException("Cupom inválido. O desconto máximo é 30%.");
        }
        return new Carrinho(this.itens, percentual);
    }

    public BigDecimal getDescontoPercentual() {
        return descontoPercentual;
    }
}
