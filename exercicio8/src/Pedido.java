import java.math.BigDecimal;

public class Pedido {
    private String cepDestino;
    private BigDecimal valorTotal;
    private FreteStrategy estrategiaFrete;

    public Pedido(String cepDestino, BigDecimal valorTotal, FreteStrategy estrategiaFrete) {
        setCepDestino(cepDestino);
        setValorTotal(valorTotal);
        setEstrategiaFrete(estrategiaFrete);
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        if (cepDestino == null || !cepDestino.matches("\\d{5}-?\\d{3}")) {
            throw new CepInvalidoException("CEP inválido: " + cepDestino);
        }
        this.cepDestino = cepDestino;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        if (valorTotal == null || valorTotal.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor do pedido inválido.");
        }
        this.valorTotal = valorTotal;
    }

    public FreteStrategy getEstrategiaFrete() {
        return estrategiaFrete;
    }

    public void setEstrategiaFrete(FreteStrategy estrategiaFrete) {
        if (estrategiaFrete == null) {
            throw new IllegalArgumentException("Estratégia de frete não pode ser nula.");
        }
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal calcularFrete() {
        return estrategiaFrete.calcular(this);
    }
}
