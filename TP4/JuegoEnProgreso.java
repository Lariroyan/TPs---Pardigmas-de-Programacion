package nogracias;

public class JuegoEnProgreso extends EstadoJuego {
    public JuegoEnProgreso(NoGracias juego) {
        super(juego);
    }
    public boolean esFinalizado() {
        return false;
    }
    public void pagarCarta(Jugador unJugador) { unJugador.pagarCarta(); }
    public void tomarCarta(Jugador unJugador, Carta unaCarta) {
        unJugador.tomarCarta(unaCarta);
    }
}
