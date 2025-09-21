import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<FormaPagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new CartaoCredito("1234567812345678")); // válido
        pagamentos.add(new Boleto("12345678901234567890123456789012345678901234567")); // válido
        pagamentos.add(new Pix("usuario@email.com")); // válido
        pagamentos.add(new CartaoCredito("111")); // inválido
        pagamentos.add(new Pix("chaveInvalida")); // inválido

        BigDecimal valor = new BigDecimal("150.00");

        for (FormaPagamento pagamento : pagamentos) {
            System.out.println("\nTestando pagamento com: " + pagamento.getClass().getSimpleName());
            try {
                pagamento.processarPagamento(valor);
            } catch (PagamentoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
