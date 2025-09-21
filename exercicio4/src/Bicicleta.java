public class Bicicleta implements IMeioTransporte {
    private int velocidade = 0;
    private final int VELOCIDADE_MAXIMA = 40;

    @Override
    public void acelerar(int incremento) {
        if (incremento < 0) {
            throw new IllegalArgumentException("Incremento não pode ser negativo.");
        }
        if (velocidade + incremento > VELOCIDADE_MAXIMA) {
            throw new IllegalArgumentException("A bicicleta não pode ultrapassar " + VELOCIDADE_MAXIMA + " km/h.");
        }
        velocidade += incremento;
    }

    @Override
    public void frear(int decremento) {
        if (decremento < 0) {
            throw new IllegalArgumentException("Decremento não pode ser negativo.");
        }
        if (velocidade - decremento < 0) {
            throw new IllegalArgumentException("A bicicleta não pode ter velocidade negativa.");
        }
        velocidade -= decremento;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String toString() {
        return "Bicicleta - Velocidade atual: " + velocidade + " km/h";
    }
}
