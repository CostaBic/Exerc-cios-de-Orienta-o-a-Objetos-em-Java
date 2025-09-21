import java.math.BigDecimal;

public class Pix extends FormaPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() {
        if (chavePix == null || chavePix.isBlank()) {
            throw new PagamentoInvalidoException("Chave Pix não pode ser vazia.");
        }

        // Validações simples: e-mail, telefone ou chave aleatória
        boolean valido = chavePix.matches(".+@.+\\..+")  // e-mail
                || chavePix.matches("\\d{11}")      // telefone (11 dígitos)
                || chavePix.matches("[a-fA-F0-9\\-]{32,36}"); // Chave aleatória

        if (!valido) {
            throw new PagamentoInvalidoException("Chave Pix inválida.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Pagamento de R$" + valor + " processado via Pix. Chave: " + chavePix);
    }
}
