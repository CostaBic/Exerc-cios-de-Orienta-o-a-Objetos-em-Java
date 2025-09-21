import java.math.BigDecimal;

// Sedex: frete fixo + variável
public class SedexFrete implements FreteStrategy {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        validarCep(pedido.getCepDestino());
        return BigDecimal.valueOf(20).add(pedido.getValorTotal().multiply(BigDecimal.valueOf(0.02)));
    }

    private void validarCep(String cep) {
        if (!cep.matches("\\d{5}-?\\d{3}")) {
            throw new CepInvalidoException("CEP inválido para Sedex: " + cep);
        }
    }
}