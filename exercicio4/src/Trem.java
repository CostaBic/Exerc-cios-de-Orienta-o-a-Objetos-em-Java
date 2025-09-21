public class Trem implements IMeioTransporte {
    private int velocidade = 0;
    private final int VELOCIDADE_MAXIMA = 300;

    @Override
    public void acelerar(int incremento) {
        if (incremento < 0) {
            throw new IllegalArgumentException("Incremento não pode ser negativo.");
        }
        if (velocidade + incremento > VELOCIDADE_MAXIMA) {
            throw new IllegalArgumentException("O trem não pode ultrapassar " + VELOCIDADE_MAXIMA + " km/h.");
        }
        velocidade += incremento;
    }

    @Override
    public void frear(int decremento) {
        if (decremento < 0) {
            throw new IllegalArgumentException("Decremento não pode ser negativo.");
        }
        if (velocidade - decremento < 0) {
            throw new IllegalArgumentException("O trem não pode ter velocidade negativa.");
        }
        velocidade -= decremento;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String toString() {
        return "Trem - Velocidade atual: " + velocidade + " km/h";
    }
}
