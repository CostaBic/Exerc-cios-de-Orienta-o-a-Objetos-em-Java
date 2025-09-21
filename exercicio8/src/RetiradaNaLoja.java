import java.math.BigDecimal;

// Retirada na loja: sempre zero
public class RetiradaNaLoja implements FreteStrategy {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return BigDecimal.ZERO;
    }
}