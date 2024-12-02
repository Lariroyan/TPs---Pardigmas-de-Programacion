package nogracias;

public class JuegoFinalizado extends EstadoJuego{
    public JuegoFinalizado(NoGracias juego) {
        super(juego);
    }

    public boolean esFinalizado() {
        return true;
    }
    public void tomarCarta(Jugador unJugador, Carta unaCarta) {
        throw new RuntimeException("Juego finalizado");
    }

    public void pagarCarta(Jugador unJugador) {
        throw new RuntimeException("Juego finalizado");
    }
}
