import java.math.BigDecimal;

public abstract class FormaPagamento {
    // Método para validação (implementação específica nas subclasses)
    public abstract void validarPagamento();

    // Método para processar pagamento (implementação específica nas subclasses)
    public abstract void processarPagamento(BigDecimal valor);
}
