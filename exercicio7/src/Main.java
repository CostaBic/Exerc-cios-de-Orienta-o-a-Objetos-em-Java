import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IRepository<Produto, Integer> repoProduto = new InMemoryRepository<>();
        IRepository<Funcionario, Integer> repoFuncionario = new InMemoryRepository<>();

        // Adicionando produtos
        Produto p1 = new Produto(1, "Notebook", new BigDecimal("3500.00"));
        Produto p2 = new Produto(2, "Mouse", new BigDecimal("150.00"));
        repoProduto.salvar(p1);
        repoProduto.salvar(p2);

        // Adicionando funcionários
        Funcionario f1 = new Funcionario(1, "Alice", new BigDecimal("5000.00"));
        Funcionario f2 = new Funcionario(2, "Bob", new BigDecimal("3000.00"));
        repoFuncionario.salvar(f1);
        repoFuncionario.salvar(f2);

        // Listando todos
        System.out.println("Produtos cadastrados:");
        List<Produto> produtos = repoProduto.listarTodos();
        produtos.forEach(System.out::println);

        System.out.println("\nFuncionários cadastrados:");
        List<Funcionario> funcionarios = repoFuncionario.listarTodos();
        funcionarios.forEach(System.out::println);

        // Buscando por ID
        System.out.println("\nBuscando Produto com ID 1:");
        repoProduto.buscarPorId(1).ifPresent(System.out::println);

        // Removendo com sucesso
        repoFuncionario.remover(2);
        System.out.println("\nApós remover funcionário ID 2:");
        repoFuncionario.listarTodos().forEach(System.out::println);

        // Tentando remover inexistente → lança exceção
        System.out.println("\nTentando remover Produto com ID 99:");
        try {
            repoProduto.remover(99);
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
