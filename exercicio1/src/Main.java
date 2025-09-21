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
                Produto teste = new Produto(nome, 0, 0); // validar
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
                Produto teste = new Produto(nome, preco, 0);
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
                Produto teste = new Produto(nome, preco, quantidade); // validação
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido para a quantidade.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }

        // Agora cria o produto
        Produto p1 = new Produto(nome, preco, quantidade);
        System.out.println("\n=== Produto criado com sucesso ===");
        p1.exibirInfo();

        sc.close();
    }
}