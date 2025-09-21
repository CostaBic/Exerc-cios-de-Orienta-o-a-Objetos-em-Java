import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Gerente("Alice", new BigDecimal("15000")));
        funcionarios.add(new Desenvolvedor("Bob", new BigDecimal("8000")));
        funcionarios.add(new Desenvolvedor("Carlos", new BigDecimal("9500")));
        funcionarios.add(new Gerente("Daniela", new BigDecimal("20000")));

        System.out.println("=== Bônus dos Funcionários ===");
        for (Funcionario f : funcionarios) {
            System.out.println(
                    f.getNome() +
                            " | Salário: R$" + f.getSalario() +
                            " | Bônus: R$" + f.calcularBonus()
            );
        }
    }
}
