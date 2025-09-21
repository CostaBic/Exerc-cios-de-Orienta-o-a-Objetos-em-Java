import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<IMeioTransporte> meios = new ArrayList<>();
        meios.add(new Carro());
        meios.add(new Bicicleta());
        meios.add(new Trem());

        for (IMeioTransporte meio : meios) {
            System.out.println("\nTestando: " + meio.getClass().getSimpleName());

            try {
                meio.acelerar(30);
                System.out.println(meio);

                meio.frear(10);
                System.out.println(meio);

                // Teste de erro: acelerar além do limite
                meio.acelerar(500);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }

            try {
                // Teste de erro: frear além do limite
                meio.frear(500);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
