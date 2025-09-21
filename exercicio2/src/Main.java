import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome;
        double preco;
        int quantidade;

        // Lendo nome
        while (true) {
            System.out.print("Digite o nome do produto: ");
            nome = sc.nextLine();
            try {
                Produto teste = new Produto(nome, 0, 0); // valida apenas nome
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }

        // Lendo preço
        while (true) {
            System.out.print("Digite o preço do produto: ");
            try {
                preco = Double.parseDouble(sc.nextLine());
                Produto teste = new Produto(nome, preco, 0); // valida preço
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido para o preço.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }

        // Lendo quantidade
        while (true) {
            System.out.print("Digite a quantidade em estoque: ");
            try {
                quantidade = Integer.parseInt(sc.nextLine());
                Produto teste = new Produto(nome, preco, quantidade); // valida quantidade
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido para a quantidade.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }

        // Criando produto com desconto (subclasse)
        ProdutoComDesconto p1 = new ProdutoComDesconto(nome, preco, quantidade);
        System.out.println("\n=== Produto criado com sucesso ===");
        p1.exibirInfo();

        // Aplicando desconto informado pelo usuário
        while (true) {
            System.out.print("\nDigite o percentual de desconto (0 a 50): ");
            try {
                double desconto = Double.parseDouble(sc.nextLine());
                System.out.println("Preço antes do desconto: R$" + String.format("%.2f", p1.getPreco()));
                p1.aplicarDesconto(desconto);
                System.out.println("Preço após desconto: R$" + String.format("%.2f", p1.getPreco()));
                break; // sai do loop se deu certo
            } catch (NumberFormatException e) {
                System.out.println("Erro: valor inválido para desconto. Digite um número.");
            } catch (DescontoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }



        sc.close();
    }
}
