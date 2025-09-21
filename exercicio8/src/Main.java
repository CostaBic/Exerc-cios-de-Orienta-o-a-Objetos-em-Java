import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Criando pedido
        Pedido pedido = new Pedido("12345-678", new BigDecimal("600"), new SedexFrete());

        // Calcular frete inicial (Sedex)
        System.out.println("Frete Sedex: R$ " + pedido.calcularFrete());

        // Trocar para PAC em tempo de execução
        pedido.setEstrategiaFrete(new PacFrete());
        System.out.println("Frete PAC: R$ " + pedido.calcularFrete());

        // Trocar para Retirada na loja
        pedido.setEstrategiaFrete(new RetiradaNaLoja());
        System.out.println("Frete Retirada na loja: R$ " + pedido.calcularFrete());

        // Aplicar estratégia promocional via lambda
        FreteStrategy freteGratisAcima = p -> {
            BigDecimal limite = BigDecimal.valueOf(500);
            if (p.getValorTotal().compareTo(limite) >= 0) {
                return BigDecimal.ZERO;
            } else {
                return BigDecimal.valueOf(15);
            }
        };
        pedido.setEstrategiaFrete(freteGratisAcima);
        System.out.println("Frete promocional: R$ " + pedido.calcularFrete());

        // Testando CEP inválido
        try {
            Pedido pedidoInvalido = new Pedido("abc", new BigDecimal("100"), new SedexFrete());
            System.out.println("Frete: " + pedidoInvalido.calcularFrete());
        } catch (CepInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
