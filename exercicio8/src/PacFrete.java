import java.math.BigDecimal;

// PAC: mais barato, só percentual
public class PacFrete implements FreteStrategy {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        validarCep(pedido.getCepDestino());
        return pedido.getValorTotal().multiply(BigDecimal.valueOf(0.01));
    }

    private void validarCep(String cep) {
        if (!cep.matches("\\d{5}-?\\d{3}")) {
            throw new CepInvalidoException("CEP inválido para PAC: " + cep);
        }
    }
}
