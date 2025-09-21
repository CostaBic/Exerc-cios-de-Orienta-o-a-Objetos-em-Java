public class Carro implements IMeioTransporte {
    private int velocidade = 0;
    private final int VELOCIDADE_MAXIMA = 200;

    @Override
    public void acelerar(int incremento) {
        if (incremento < 0) {
            throw new IllegalArgumentException("Incremento não pode ser negativo.");
        }
        if (velocidade + incremento > VELOCIDADE_MAXIMA) {
            throw new IllegalArgumentException("O carro não pode ultrapassar " + VELOCIDADE_MAXIMA + " km/h.");
        }
        velocidade += incremento;
    }

    @Override
    public void frear(int decremento) {
        if (decremento < 0) {
            throw new IllegalArgumentException("Decremento não pode ser negativo.");
        }
        if (velocidade - decremento < 0) {
            throw new IllegalArgumentException("O carro não pode ter velocidade negativa.");
        }
        velocidade -= decremento;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String toString() {
        return "Carro - Velocidade atual: " + velocidade + " km/h";
    }
}
